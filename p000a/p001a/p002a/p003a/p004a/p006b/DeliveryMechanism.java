package p000a.p001a.p002a.p003a.p004a.p006b;

/* renamed from: a.a.a.a.a.b.l */
public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    
    private final int f40e;

    private DeliveryMechanism(int i) {
        this.f40e = i;
    }

    public int m86a() {
        return this.f40e;
    }

    public String toString() {
        return Integer.toString(this.f40e);
    }

    public static DeliveryMechanism m85a(String str) {
        if ("io.crash.air".equals(str)) {
            return TEST_DISTRIBUTION;
        }
        if (str != null) {
            return APP_STORE;
        }
        return DEVELOPER;
    }
}
