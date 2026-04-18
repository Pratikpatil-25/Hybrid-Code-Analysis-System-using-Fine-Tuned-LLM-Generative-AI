package com.platform.ems.service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.platform.common.core.domain.AjaxResult;
import com.platform.ems.domain.InvInventoryAdjust;
import com.platform.ems.domain.InvInventoryAdjustItem;
import com.platform.ems.domain.dto.request.InvCrossColorReportRequest;
import com.platform.ems.domain.dto.request.InvInventoryAdjustReportRequest;
import com.platform.ems.domain.dto.request.OrderErrRequest;
import com.platform.ems.domain.dto.response.InvCrossColorReportResponse;
import com.platform.ems.domain.dto.response.InvInventoryAdjustReportResponse;
import org.springframework.web.multipart.MultipartFile;


public interface IInvInventoryAdjustService extends IService<InvInventoryAdjust>{
    
    public InvInventoryAdjust selectInvInventoryAdjustById(Long inventoryAdjustSid);
    public List<InvInventoryAdjustItem> sort(List<InvInventoryAdjustItem> items, String type);
    
    public List<InvInventoryAdjust> selectInvInventoryAdjustList(InvInventoryAdjust invInventoryAdjust);
    
    List<InvInventoryAdjustReportResponse> reportInvInventoryAdjust(InvInventoryAdjustReportRequest request);

    
    public List<InvCrossColorReportResponse> reportCrossColor(InvCrossColorReportRequest request);

    
    public int insertInvInventoryAdjust(InvInventoryAdjust invInventoryAdjust);

    
    public int updateInvInventoryAdjust(InvInventoryAdjust invInventoryAdjust);

    
    public int deleteInvInventoryAdjustByIds(Long[] inventoryAdjustSids);

    
    int confirm(InvInventoryAdjust invInventoryAdjust);

    
    int change(InvInventoryAdjust invInventoryAdjust);

    
    public InvInventoryAdjust getCopy(Long sid);
    public OrderErrRequest processCheck(OrderErrRequest request);
    
    public AjaxResult importDataInv(MultipartFile file);
}