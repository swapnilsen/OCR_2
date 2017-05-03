package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest.Gender;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest {
    private final Date f2270a;
    private final Gender f2271b;
    private final Set<String> f2272c;
    private final boolean f2273d;
    private final Location f2274e;

    public MediationAdRequest(Date date, Gender gender, Set<String> set, boolean z, Location location) {
        this.f2270a = date;
        this.f2271b = gender;
        this.f2272c = set;
        this.f2273d = z;
        this.f2274e = location;
    }

    public Integer getAgeInYears() {
        if (this.f2270a == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.f2270a);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.f2270a;
    }

    public Gender getGender() {
        return this.f2271b;
    }

    public Set<String> getKeywords() {
        return this.f2272c;
    }

    public Location getLocation() {
        return this.f2274e;
    }

    public boolean isTesting() {
        return this.f2273d;
    }
}
