package com.crashlytics.android.core;

import java.util.HashMap;
import java.util.Map;

class RemoveRepeatsStrategy implements StackTraceTrimmingStrategy {
    private final int maxRepetitions;

    public RemoveRepeatsStrategy() {
        this(1);
    }

    public RemoveRepeatsStrategy(int i) {
        this.maxRepetitions = i;
    }

    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement[] trimRepeats = trimRepeats(stackTraceElementArr, this.maxRepetitions);
        if (trimRepeats.length < stackTraceElementArr.length) {
            return trimRepeats;
        }
        return stackTraceElementArr;
    }

    private static StackTraceElement[] trimRepeats(StackTraceElement[] stackTraceElementArr, int i) {
        Map hashMap = new HashMap();
        Object obj = new StackTraceElement[stackTraceElementArr.length];
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < stackTraceElementArr.length) {
            int i5;
            Object obj2 = stackTraceElementArr[i2];
            Integer num = (Integer) hashMap.get(obj2);
            if (num == null || !isRepeatingSequence(stackTraceElementArr, num.intValue(), i2)) {
                obj[i4] = stackTraceElementArr[i2];
                i4++;
                i5 = i2;
                i3 = 1;
            } else {
                i5 = i2 - num.intValue();
                if (i3 < i) {
                    System.arraycopy(stackTraceElementArr, i2, obj, i4, i5);
                    i4 += i5;
                    i3++;
                }
                i5 = (i5 - 1) + i2;
            }
            hashMap.put(obj2, Integer.valueOf(i2));
            i2 = i5 + 1;
        }
        Object obj3 = new StackTraceElement[i4];
        System.arraycopy(obj, 0, obj3, 0, obj3.length);
        return obj3;
    }

    private static boolean isRepeatingSequence(StackTraceElement[] stackTraceElementArr, int i, int i2) {
        int i3 = i2 - i;
        if (i2 + i3 > stackTraceElementArr.length) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!stackTraceElementArr[i + i4].equals(stackTraceElementArr[i2 + i4])) {
                return false;
            }
        }
        return true;
    }
}
