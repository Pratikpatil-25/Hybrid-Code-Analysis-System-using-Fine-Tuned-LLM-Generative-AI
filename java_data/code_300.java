package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.microsoft.identity.common.java.crypto.key.KeyUtil;
import java.security.MessageDigest;
import java.util.concurrent.Callable;



public final class PG8 {
    public static volatile InterfaceC19343tm6 g;
    public static Context i;
    public static final NB8 a = new I18(Zx8.M0("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u007f¢fú§p\u0085xb±"));
    public static final NB8 b = new BinderC21752xi8(Zx8.M0("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014QÕÛ\u0004÷XçB\u0086<"));
    public static final NB8 c = new BinderC18754so8(Zx8.M0("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
    public static final NB8 d = new Rq8(Zx8.M0("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
    public static final NB8 e = new BinderC12671it8(Zx8.M0("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
    public static final NB8 f = new Dv8(Zx8.M0("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
    public static final Object h = new Object();

    @Deprecated
    public static C5052Rk6 a(String str, Zx8 zx8, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return g(str, zx8, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public static C5052Rk6 b(C19914ui6 c19914ui6) {
        C5052Rk6 d2;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            C17215qI3.l(i);
            try {
                h();
                C17215qI3.l(i);
                HJ8 a2 = c19914ui6.a(i);
                try {
                    d2 = f(c19914ui6.b() ? g.O6(a2) : g.C5(a2));
                } catch (RemoteException e2) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                    d2 = C5052Rk6.d("module call", e2);
                }
            } catch (DynamiteModule.a e3) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
                d2 = C5052Rk6.d("module init: ".concat(String.valueOf(e3.getMessage())), e3);
            }
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return d2;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th;
        }
    }

    public static  String c(boolean z, String str, Zx8 zx8) {
        String str2 = (z || !g(str, zx8, true, false).a) ? "not allowed" : "debug cert rejected";
        MessageDigest b2 = C0764Ak.b(KeyUtil.HMAC_KEY_HASH_ALGORITHM);
        C17215qI3.l(b2);
        return String.format("%s: pkg=%s, sha256=%s, atk=%s, ver=%s", str2, str, C13065jW1.a(b2.digest(zx8.v2())), Boolean.valueOf(z), "12451000.false");
    }

    public static synchronized void d(Context context) {
        synchronized (PG8.class) {
            if (i != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                i = context.getApplicationContext();
            }
        }
    }

    public static boolean e() {
        boolean z;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            try {
                h();
                z = g.h();
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        } catch (RemoteException | DynamiteModule.a e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            z = false;
        }
        return z;
    }

    public static C5052Rk6 f(FL8 fl8) {
        if (fl8.t()) {
            FL8 j = fl8.j();
            return C5052Rk6.f(fl8.K(), fl8.i(), j != null ? f(j) : null);
        }
        String m = fl8.m();
        PackageManager.NameNotFoundException nameNotFoundException = fl8.U() == 4 ? new PackageManager.NameNotFoundException() : null;
        if (m == null) {
            m = "error checking package certificate";
        }
        return C5052Rk6.g(fl8.K(), fl8.U(), m, nameNotFoundException);
    }

    @Deprecated
    public static C5052Rk6 g(final String str, final Zx8 zx8, final boolean z, boolean z2) {
        try {
            h();
            C17215qI3.l(i);
            try {
                return g.j3(new C17270qN8(str, zx8, z, z2), BinderC1218Cf3.v2(i.getPackageManager())) ? C5052Rk6.b() : new C15032mj6(new Callable() {                     @Override                     public final Object call() {
                        return PG8.c(z, str, zx8);
                    }
                }, null);
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return C5052Rk6.d("module call", e2);
            }
        } catch (DynamiteModule.a e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            return C5052Rk6.d("module init: ".concat(String.valueOf(e3.getMessage())), e3);
        }
    }

    public static void h() {
        if (g != null) {
            return;
        }
        C17215qI3.l(i);
        synchronized (h) {
            try {
                if (g == null) {
                    g = AbstractBinderC2282Gl6.E0(DynamiteModule.e(i, DynamiteModule.f, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}