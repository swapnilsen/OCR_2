package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonPrimitive extends JsonElement {
    private static final Class<?>[] f4687a;
    private Object f4688b;

    static {
        f4687a = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
    }

    public JsonPrimitive(Boolean bool) {
        m5328a((Object) bool);
    }

    public JsonPrimitive(Number number) {
        m5328a((Object) number);
    }

    public JsonPrimitive(String str) {
        m5328a((Object) str);
    }

    public JsonPrimitive(Character ch) {
        m5328a((Object) ch);
    }

    JsonPrimitive(Object obj) {
        m5328a(obj);
    }

    void m5328a(Object obj) {
        if (obj instanceof Character) {
            this.f4688b = String.valueOf(((Character) obj).charValue());
            return;
        }
        boolean z = (obj instanceof Number) || m5326b(obj);
        C$Gson$Preconditions.checkArgument(z);
        this.f4688b = obj;
    }

    public boolean isBoolean() {
        return this.f4688b instanceof Boolean;
    }

    Boolean m5327a() {
        return (Boolean) this.f4688b;
    }

    public boolean getAsBoolean() {
        if (isBoolean()) {
            return m5327a().booleanValue();
        }
        return Boolean.parseBoolean(getAsString());
    }

    public boolean isNumber() {
        return this.f4688b instanceof Number;
    }

    public Number getAsNumber() {
        return this.f4688b instanceof String ? new LazilyParsedNumber((String) this.f4688b) : (Number) this.f4688b;
    }

    public boolean isString() {
        return this.f4688b instanceof String;
    }

    public String getAsString() {
        if (isNumber()) {
            return getAsNumber().toString();
        }
        if (isBoolean()) {
            return m5327a().toString();
        }
        return (String) this.f4688b;
    }

    public double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    public BigDecimal getAsBigDecimal() {
        return this.f4688b instanceof BigDecimal ? (BigDecimal) this.f4688b : new BigDecimal(this.f4688b.toString());
    }

    public BigInteger getAsBigInteger() {
        if (this.f4688b instanceof BigInteger) {
            return (BigInteger) this.f4688b;
        }
        return new BigInteger(this.f4688b.toString());
    }

    public float getAsFloat() {
        return isNumber() ? getAsNumber().floatValue() : Float.parseFloat(getAsString());
    }

    public long getAsLong() {
        return isNumber() ? getAsNumber().longValue() : Long.parseLong(getAsString());
    }

    public short getAsShort() {
        return isNumber() ? getAsNumber().shortValue() : Short.parseShort(getAsString());
    }

    public int getAsInt() {
        return isNumber() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
    }

    public byte getAsByte() {
        return isNumber() ? getAsNumber().byteValue() : Byte.parseByte(getAsString());
    }

    public char getAsCharacter() {
        return getAsString().charAt(0);
    }

    private static boolean m5326b(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class cls = obj.getClass();
        for (Class isAssignableFrom : f4687a) {
            if (isAssignableFrom.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f4688b == null) {
            return 31;
        }
        long longValue;
        if (m5325a(this)) {
            longValue = getAsNumber().longValue();
            return (int) (longValue ^ (longValue >>> 32));
        } else if (!(this.f4688b instanceof Number)) {
            return this.f4688b.hashCode();
        } else {
            longValue = Double.doubleToLongBits(getAsNumber().doubleValue());
            return (int) (longValue ^ (longValue >>> 32));
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        if (this.f4688b == null) {
            if (jsonPrimitive.f4688b != null) {
                return false;
            }
            return true;
        } else if (m5325a(this) && m5325a(jsonPrimitive)) {
            if (getAsNumber().longValue() != jsonPrimitive.getAsNumber().longValue()) {
                return false;
            }
            return true;
        } else if (!(this.f4688b instanceof Number) || !(jsonPrimitive.f4688b instanceof Number)) {
            return this.f4688b.equals(jsonPrimitive.f4688b);
        } else {
            double doubleValue = getAsNumber().doubleValue();
            double doubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
            if (doubleValue == doubleValue2 || (Double.isNaN(doubleValue) && Double.isNaN(doubleValue2))) {
                z = true;
            }
            return z;
        }
    }

    private static boolean m5325a(JsonPrimitive jsonPrimitive) {
        if (!(jsonPrimitive.f4688b instanceof Number)) {
            return false;
        }
        Number number = (Number) jsonPrimitive.f4688b;
        if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
            return true;
        }
        return false;
    }
}
