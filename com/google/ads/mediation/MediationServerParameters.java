package com.google.ads.mediation;

import com.google.android.gms.internal.zzqf;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
public abstract class MediationServerParameters {

    public static final class MappingException extends Exception {
        public MappingException(String str) {
            super(str);
        }
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Parameter {
        String name();

        boolean required() default true;
    }

    public void load(Map<String, String> map) {
        String str;
        Map hashMap = new HashMap();
        for (Field field : getClass().getFields()) {
            Parameter parameter = (Parameter) field.getAnnotation(Parameter.class);
            if (parameter != null) {
                hashMap.put(parameter.name(), field);
            }
        }
        if (hashMap.isEmpty()) {
            zzqf.zzbh("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (Entry entry : map.entrySet()) {
            Field field2 = (Field) hashMap.remove(entry.getKey());
            if (field2 != null) {
                try {
                    field2.set(this, entry.getValue());
                } catch (IllegalAccessException e) {
                    str = (String) entry.getKey();
                    zzqf.zzbh(new StringBuilder(String.valueOf(str).length() + 49).append("Server option \"").append(str).append("\" could not be set: Illegal Access").toString());
                } catch (IllegalArgumentException e2) {
                    str = (String) entry.getKey();
                    zzqf.zzbh(new StringBuilder(String.valueOf(str).length() + 43).append("Server option \"").append(str).append("\" could not be set: Bad Type").toString());
                }
            } else {
                str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                zzqf.zzbf(new StringBuilder((String.valueOf(str).length() + 31) + String.valueOf(str2).length()).append("Unexpected server option: ").append(str).append(" = \"").append(str2).append("\"").toString());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field22 : hashMap.values()) {
            if (((Parameter) field22.getAnnotation(Parameter.class)).required()) {
                String str3 = "Required server option missing: ";
                str2 = String.valueOf(((Parameter) field22.getAnnotation(Parameter.class)).name());
                zzqf.zzbh(str2.length() != 0 ? str3.concat(str2) : new String(str3));
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(((Parameter) field22.getAnnotation(Parameter.class)).name());
            }
        }
        if (stringBuilder.length() > 0) {
            String str4 = "Required server option(s) missing: ";
            str = String.valueOf(stringBuilder.toString());
            throw new MappingException(str.length() != 0 ? str4.concat(str) : new String(str4));
        }
    }
}
