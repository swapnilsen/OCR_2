package android.support.transition;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

public class TransitionValues {
    public final Map<String, Object> values;
    public View view;

    public TransitionValues() {
        this.values = new HashMap();
    }

    public boolean equals(Object obj) {
        if ((obj instanceof TransitionValues) && this.view == ((TransitionValues) obj).view && this.values.equals(((TransitionValues) obj).values)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.view.hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.view + "\n") + "    values:";
        String str2 = str;
        for (String str3 : this.values.keySet()) {
            str2 = str2 + "    " + str3 + ": " + this.values.get(str3) + "\n";
        }
        return str2;
    }
}
