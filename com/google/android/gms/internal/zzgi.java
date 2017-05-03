package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Map;

@zzme
public abstract class zzgi {
    @zzme
    public static final zzgi zzFH;
    @zzme
    public static final zzgi zzFI;
    @zzme
    public static final zzgi zzFJ;

    /* renamed from: com.google.android.gms.internal.zzgi.1 */
    class C11881 extends zzgi {
        C11881() {
        }

        public String zzg(@Nullable String str, String str2) {
            return str2;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgi.2 */
    class C11892 extends zzgi {
        C11892() {
        }

        public String zzg(@Nullable String str, String str2) {
            return str != null ? str : str2;
        }
    }

    /* renamed from: com.google.android.gms.internal.zzgi.3 */
    class C11903 extends zzgi {
        C11903() {
        }

        @Nullable
        private String zzW(@Nullable String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int i = 0;
            int length = str.length();
            while (i < str.length() && str.charAt(i) == ',') {
                i++;
            }
            while (length > 0 && str.charAt(length - 1) == ',') {
                length--;
            }
            return (i == 0 && length == str.length()) ? str : str.substring(i, length);
        }

        public String zzg(@Nullable String str, String str2) {
            String zzW = zzW(str);
            String zzW2 = zzW(str2);
            return TextUtils.isEmpty(zzW) ? zzW2 : TextUtils.isEmpty(zzW2) ? zzW : new StringBuilder((String.valueOf(zzW).length() + 1) + String.valueOf(zzW2).length()).append(zzW).append(",").append(zzW2).toString();
        }
    }

    static {
        zzFH = new C11881();
        zzFI = new C11892();
        zzFJ = new C11903();
    }

    public final void zza(Map<String, String> map, String str, String str2) {
        map.put(str, zzg((String) map.get(str), str2));
    }

    public abstract String zzg(@Nullable String str, String str2);
}
