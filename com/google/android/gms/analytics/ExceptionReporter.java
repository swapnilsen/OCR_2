package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders.ExceptionBuilder;
import com.google.android.gms.internal.zztc;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;

public class ExceptionReporter implements UncaughtExceptionHandler {
    private final Context mContext;
    private final UncaughtExceptionHandler zzabC;
    private final Tracker zzabD;
    private ExceptionParser zzabE;
    private GoogleAnalytics zzabF;

    public ExceptionReporter(Tracker tracker, UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        if (tracker == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (context == null) {
            throw new NullPointerException("context cannot be null");
        } else {
            this.zzabC = uncaughtExceptionHandler;
            this.zzabD = tracker;
            this.zzabE = new StandardExceptionParser(context, new ArrayList());
            this.mContext = context.getApplicationContext();
            String str = "ExceptionReporter created, original handler is ";
            String valueOf = String.valueOf(uncaughtExceptionHandler == null ? "null" : uncaughtExceptionHandler.getClass().getName());
            zztc.m4710v(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        }
    }

    public ExceptionParser getExceptionParser() {
        return this.zzabE;
    }

    public void setExceptionParser(ExceptionParser exceptionParser) {
        this.zzabE = exceptionParser;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str = "UncaughtException";
        if (this.zzabE != null) {
            str = this.zzabE.getDescription(thread != null ? thread.getName() : null, th);
        }
        String str2 = "Reporting uncaught exception: ";
        String valueOf = String.valueOf(str);
        zztc.m4710v(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
        this.zzabD.send(new ExceptionBuilder().setDescription(str).setFatal(true).build());
        GoogleAnalytics zzmu = zzmu();
        zzmu.dispatchLocalHits();
        zzmu.zzmz();
        if (this.zzabC != null) {
            zztc.m4710v("Passing exception to the original handler");
            this.zzabC.uncaughtException(thread, th);
        }
    }

    GoogleAnalytics zzmu() {
        if (this.zzabF == null) {
            this.zzabF = GoogleAnalytics.getInstance(this.mContext);
        }
        return this.zzabF;
    }

    UncaughtExceptionHandler zzmv() {
        return this.zzabC;
    }
}
