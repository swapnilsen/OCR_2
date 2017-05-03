package com.facebook.ads.internal.p030f;

/* renamed from: com.facebook.ads.internal.f.f */
abstract class C0545f<T> {
    private C0550a f1202a;

    /* renamed from: com.facebook.ads.internal.f.f.a */
    public enum C0550a {
        UNKNOWN(9000, "An unknown error has occurred."),
        DATABASE_SELECT(3001, "Failed to read from database."),
        DATABASE_INSERT(3002, "Failed to insert row into database."),
        DATABASE_UPDATE(3003, "Failed to update row in database."),
        DATABASE_DELETE(3004, "Failed to delete row from database.");
        
        private final int f1216f;
        private final String f1217g;

        private C0550a(int i, String str) {
            this.f1216f = i;
            this.f1217g = str;
        }

        public int m1702a() {
            return this.f1216f;
        }

        public String m1703b() {
            return this.f1217g;
        }
    }

    C0545f() {
    }

    protected void m1685a(C0550a c0550a) {
        this.f1202a = c0550a;
    }

    abstract T m1686b();

    public C0550a m1687c() {
        return this.f1202a;
    }
}
