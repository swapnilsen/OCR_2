package p000a.p001a.p002a.p003a.p004a.p006b;

import com.google.api.client.http.HttpStatusCodes;

/* renamed from: a.a.a.a.a.b.r */
public class ResponseParser {
    public static int m139a(int i) {
        if (i >= HttpStatusCodes.STATUS_CODE_OK && i <= 299) {
            return 0;
        }
        if (i >= HttpStatusCodes.STATUS_CODE_MULTIPLE_CHOICES && i <= 399) {
            return 1;
        }
        if (i >= 400 && i <= 499) {
            return 0;
        }
        if (i >= HttpStatusCodes.STATUS_CODE_SERVER_ERROR) {
            return 1;
        }
        return 1;
    }
}
