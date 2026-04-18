package com.lynn.user.service;

import com.lynn.user.model.in.AccessTokenIn;
import com.lynn.user.model.in.AuthorizeIn;
import com.lynn.user.model.in.RefreshTokenIn;
import com.lynn.user.model.out.AccessTokenOut;
import com.lynn.user.model.out.ApplicationOut;
import com.lynn.user.result.Code;
import com.lynn.user.result.SingleResult;
import com.lynn.user.utils.Algorithm;
import com.lynn.user.utils.MessageDigestUtils;
import com.lynn.user.utils.XXTEA;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class OAuthService extends BaseService{

    @Autowired
    private StringRedisTemplate template;
    @Value("${self.data.redis.code.expire}")
    private int codeExpire;
    @Value("${self.data.redis.access_token.expire}")
    private int accessTokenExpire;
    @Value("${self.data.redis.refresh_token.expire}")
    private int refreshTokenExpire;
    @Value("${self.data.xxtea_key}")
    private String xxteaKey;

    
    public SingleResult<String> authorize(AuthorizeIn authorize){
        SingleResult<String> result = new SingleResult<>();
                ApplicationOut applicationOut = applicationMapper.findByClientId(authorize.getClientId());
        if(null != applicationOut){
                        String openid = authorize.getOpenid();
            String code = getAuthorizeCode(openid);
            StringBuilder uri = new StringBuilder(authorize.getRedirectUri());
            uri.append("?code=").append(code);
            if(StringUtils.isNotBlank(authorize.getState())){
                uri.append("&state=").append(authorize.getState());
            }
                                    template.opsForValue().set(getRedisCodeKey(authorize.getClientId(),authorize.getRedirectUri()),code,codeExpire, TimeUnit.SECONDS);
            result.setCode(Code.SUCCESS);
            result.setData(uri.toString());

        }else {
            result.setCode(Code.ERROR);
            result.setMessage("invalid client_id");
        }
        return result;
    }

    
    public SingleResult<AccessTokenOut> getAccessToken(AccessTokenIn accessTokenIn){
        SingleResult<AccessTokenOut> result = new SingleResult<>();
                String code = template.opsForValue().get(getRedisCodeKey(accessTokenIn.getClientId(),accessTokenIn.getRedirectUri()));
        if(StringUtils.isNotBlank(code)){
            if(code.equals(accessTokenIn.getCode())){
                                ApplicationOut applicationOut = applicationMapper.findByClientIdAndSecret(accessTokenIn.getClientId(),accessTokenIn.getSecret());
                if(null != applicationOut){
                                                                                                    AccessTokenOut accessTokenOut = getAccessTokenOut(accessTokenIn.getClientId(),accessTokenIn.getSecret());
                    try {
                        accessTokenOut.setOpenid(XXTEA.decrypt(code,xxteaKey));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    result.setCode(Code.SUCCESS);
                    result.setData(accessTokenOut);
                }else {
                    result.setCode(Code.ERROR);
                    result.setMessage("invalid client_id or secret");
                }
            }else {
                result.setCode(Code.ERROR);
                result.setMessage("invalid code");
            }
        }else {
            result.setCode(Code.ERROR);
            result.setMessage("code不存在！");
        }
        return result;
    }

    
    public SingleResult<AccessTokenOut> getAccessToken(RefreshTokenIn refreshTokenIn){
        SingleResult<AccessTokenOut> result = new SingleResult<>();
                        String refreshTokenRedis = template.opsForValue().get(refreshTokenIn.getClientId()+"refresh_token");
        if(StringUtils.isNotBlank(refreshTokenRedis)){
                        ApplicationOut applicationOut = applicationMapper.findByClientIdAndSecret(refreshTokenIn.getClientId(),refreshTokenIn.getSecret());
            if(null != applicationOut){
                                                                                AccessTokenOut accessTokenOut = getAccessTokenOut(refreshTokenIn.getClientId(),refreshTokenIn.getSecret());
                result.setCode(Code.SUCCESS);
                result.setData(accessTokenOut);
            }else {
                result.setCode(Code.ERROR);
                result.setMessage("invalid client_id or secret");
            }
        }else {
            result.setCode(Code.ERROR);
            result.setMessage("invalid refresh_token");
        }
        return result;
    }

    public AccessTokenOut getAccessTokenOut(String clientId,String secret){
        String accessToken = getAccessToken(clientId,secret);
        String refreshToken = getAccessToken(clientId,secret);
        AccessTokenOut accessTokenOut = new AccessTokenOut();
        accessTokenOut.setAccessToken(accessToken);
        accessTokenOut.setRefreshToken(refreshToken);
        accessTokenOut.setExpiresIn(accessTokenExpire);
        template.opsForValue().set(clientId+"access_token",accessToken,accessTokenExpire,TimeUnit.SECONDS);
        template.opsForValue().set(clientId+"refresh_token",refreshToken,refreshTokenExpire,TimeUnit.SECONDS);
        return accessTokenOut;
    }

    
    private String getRedisCodeKey(String clientId,String redirectUri){
        return new StringBuilder(clientId).append('-').append(redirectUri).toString();
    }

    
    protected String getAuthorizeCode(String openid){
        return XXTEA.encrypt(openid,xxteaKey);
    }

    
    private String getAccessToken(String clientId,String secret){
        return MessageDigestUtils.encrypt(clientId+secret+System.currentTimeMillis(), Algorithm.SHA1);
    }

    
    private String getRefreshToken(String clientId,String secret){
        return MessageDigestUtils.encrypt(clientId+secret+System.currentTimeMillis()+ new Random().nextInt(100),Algorithm.SHA1);
    }
}