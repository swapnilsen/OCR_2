package p000a.p001a.p002a.p003a;

/* renamed from: a.a.a.a.f */
public interface InitializationCallback<T> {
    public static final InitializationCallback f295d;

    /* renamed from: a.a.a.a.f.a */
    public static class InitializationCallback implements InitializationCallback<Object> {
        private InitializationCallback() {
        }

        public void m415a(Object obj) {
        }

        public void m414a(Exception exception) {
        }
    }

    void m381a(Exception exception);

    void m382a(T t);

    static {
        f295d = new InitializationCallback();
    }
}
