package com.google.gson.internal;

import java.math.BigDecimal;

public final class LazilyParsedNumber extends Number {
    private final String f4738a;

    public LazilyParsedNumber(String str) {
        this.f4738a = str;
    }

    public int intValue() {
        try {
            return Integer.parseInt(this.f4738a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.f4738a);
            } catch (NumberFormatException e2) {
                return new BigDecimal(this.f4738a).intValue();
            }
        }
    }

    public long longValue() {
        try {
            return Long.parseLong(this.f4738a);
        } catch (NumberFormatException e) {
            return new BigDecimal(this.f4738a).longValue();
        }
    }

    public float floatValue() {
        return Float.parseFloat(this.f4738a);
    }

    public double doubleValue() {
        return Double.parseDouble(this.f4738a);
    }

    public String toString() {
        return this.f4738a;
    }

    public int hashCode() {
        return this.f4738a.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazilyParsedNumber)) {
            return false;
        }
        LazilyParsedNumber lazilyParsedNumber = (LazilyParsedNumber) obj;
        if (this.f4738a == lazilyParsedNumber.f4738a || this.f4738a.equals(lazilyParsedNumber.f4738a)) {
            return true;
        }
        return false;
    }
}
