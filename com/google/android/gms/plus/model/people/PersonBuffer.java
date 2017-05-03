package com.google.android.gms.plus.model.people;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzazf;
import com.google.android.gms.internal.zzazq;

public final class PersonBuffer extends AbstractDataBuffer<Person> {
    private final zzd<zzazf> zzbCX;

    public PersonBuffer(DataHolder dataHolder) {
        super(dataHolder);
        if (dataHolder.zzxf() == null || !dataHolder.zzxf().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)) {
            this.zzbCX = null;
        } else {
            this.zzbCX = new zzd(dataHolder, zzazf.CREATOR);
        }
    }

    public Person get(int i) {
        return this.zzbCX != null ? (Person) ((SafeParcelable) this.zzbCX.get(i)) : new zzazq(this.zzaBi, i);
    }
}
