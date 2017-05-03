package p000a.p001a.p002a.p003a.p004a.p010e;

import java.io.InputStream;

/* renamed from: a.a.a.a.a.e.g */
public interface PinningInfoProvider {
    String getKeyStorePassword();

    InputStream getKeyStoreStream();

    long getPinCreationTimeInMillis();

    String[] getPins();
}
