package net.nend.android;

final class NendException extends Exception {
    private static final long serialVersionUID = -1250523971139030161L;

    NendException() {
    }

    NendException(String str, Throwable th) {
        super(str, th);
    }

    NendException(String str) {
        super(str);
    }

    NendException(Throwable th) {
        super(th);
    }

    NendException(NendStatus nendStatus) {
        this(nendStatus.getMsg());
    }

    NendException(NendStatus nendStatus, String str) {
        this(nendStatus.getMsg(str));
    }
}
