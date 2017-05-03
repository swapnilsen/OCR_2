package com.google.android.exoplayer2.p064g.p065a;

import android.support.v4.media.TransportMediator;
import android.support.v7.appcompat.C0268R;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.text.TextUtils;
import com.google.ads.AdSize;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p064g.Cue;
import com.google.android.exoplayer2.p064g.Subtitle;
import com.google.android.exoplayer2.p064g.SubtitleInputBuffer;
import com.google.android.exoplayer2.p064g.SubtitleOutputBuffer;
import com.google.api.client.http.HttpStatusCodes;

/* renamed from: com.google.android.exoplayer2.g.a.a */
public final class Cea608Decoder extends CeaDecoder {
    private static final int[] f3414a;
    private static final int[] f3415b;
    private static final int[] f3416c;
    private static final int[] f3417d;
    private final ParsableByteArray f3418e;
    private final StringBuilder f3419f;
    private int f3420g;
    private int f3421h;
    private String f3422i;
    private String f3423j;
    private boolean f3424k;
    private byte f3425l;
    private byte f3426m;

    public /* bridge */ /* synthetic */ SubtitleOutputBuffer m3999g() {
        return super.m3976g();
    }

    public /* bridge */ /* synthetic */ SubtitleInputBuffer m4000h() {
        return super.m3977h();
    }

    static {
        f3414a = new int[]{32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 97, 98, 99, 100, C0268R.styleable.AppCompatTheme_autoCompleteTextViewStyle, C0268R.styleable.AppCompatTheme_buttonStyle, C0268R.styleable.AppCompatTheme_buttonStyleSmall, C0268R.styleable.AppCompatTheme_checkboxStyle, C0268R.styleable.AppCompatTheme_checkedTextViewStyle, C0268R.styleable.AppCompatTheme_editTextStyle, C0268R.styleable.AppCompatTheme_radioButtonStyle, C0268R.styleable.AppCompatTheme_ratingBarStyle, C0268R.styleable.AppCompatTheme_ratingBarStyleIndicator, C0268R.styleable.AppCompatTheme_ratingBarStyleSmall, C0268R.styleable.AppCompatTheme_seekBarStyle, C0268R.styleable.AppCompatTheme_spinnerStyle, C0268R.styleable.AppCompatTheme_switchStyle, C0268R.styleable.AppCompatTheme_listMenuViewStyle, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
        f3415b = new int[]{174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
        f3416c = new int[]{193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, HttpStatusCodes.STATUS_CODE_OK, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
        f3417d = new int[]{195, 227, 205, HttpStatusCodes.STATUS_CODE_NO_CONTENT, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, TransportMediator.KEYCODE_MEDIA_PLAY, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    }

    public Cea608Decoder() {
        this.f3418e = new ParsableByteArray();
        this.f3419f = new StringBuilder();
        m3979a(0);
        this.f3421h = 4;
    }

    public void m3995c() {
        super.m3972c();
        m3979a(0);
        this.f3421h = 4;
        this.f3419f.setLength(0);
        this.f3422i = null;
        this.f3423j = null;
        this.f3424k = false;
        this.f3425l = (byte) 0;
        this.f3426m = (byte) 0;
    }

    public void m3996d() {
    }

    protected boolean m3997e() {
        return !TextUtils.equals(this.f3422i, this.f3423j);
    }

    protected Subtitle m3998f() {
        this.f3423j = this.f3422i;
        return new CeaSubtitle(new Cue(this.f3422i));
    }

    protected void m3993a(SubtitleInputBuffer subtitleInputBuffer) {
        this.f3418e.m4450a(subtitleInputBuffer.b.array(), subtitleInputBuffer.b.limit());
        boolean z = false;
        boolean z2 = false;
        while (this.f3418e.m4452b() > 0) {
            byte g = (byte) (this.f3418e.m4461g() & TransportMediator.KEYCODE_MEDIA_PAUSE);
            byte g2 = (byte) (this.f3418e.m4461g() & TransportMediator.KEYCODE_MEDIA_PAUSE);
            if (((byte) (this.f3418e.m4461g() & 7)) == 4 && !(g == null && g2 == null)) {
                if ((g == 17 || g == 25) && (g2 & C0268R.styleable.AppCompatTheme_spinnerStyle) == 48) {
                    this.f3419f.append(Cea608Decoder.m3984c(g2));
                    z2 = true;
                } else {
                    if ((g2 & 96) == 32) {
                        if (g == 18 || g == 26) {
                            m3989i();
                            this.f3419f.append(Cea608Decoder.m3986d(g2));
                            z2 = true;
                        } else if (g == 19 || g == 27) {
                            m3989i();
                            this.f3419f.append(Cea608Decoder.m3987e(g2));
                            z2 = true;
                        }
                    }
                    if (g < (byte) 32) {
                        z = m3980a(g, g2);
                        z2 = true;
                    } else {
                        this.f3419f.append(Cea608Decoder.m3982b(g));
                        if (g2 >= (byte) 32) {
                            this.f3419f.append(Cea608Decoder.m3982b(g2));
                        }
                        z2 = true;
                    }
                }
            }
        }
        if (z2) {
            if (!z) {
                this.f3424k = false;
            }
            if (this.f3420g == 1 || this.f3420g == 3) {
                this.f3422i = m3991k();
            }
        }
    }

    private boolean m3980a(byte b, byte b2) {
        boolean f = Cea608Decoder.m3988f(b);
        if (f) {
            if (this.f3424k && this.f3425l == b && this.f3426m == b2) {
                this.f3424k = false;
                return true;
            }
            this.f3424k = true;
            this.f3425l = b;
            this.f3426m = b2;
        }
        if (Cea608Decoder.m3983b(b, b2)) {
            m3978a(b2);
        } else if (Cea608Decoder.m3985c(b, b2)) {
            m3990j();
        }
        return f;
    }

    private void m3978a(byte b) {
        switch (b) {
            case AdSize.LANDSCAPE_AD_HEIGHT /*32*/:
                m3979a(2);
            case C0268R.styleable.AppCompatTheme_actionModeFindDrawable /*37*/:
                this.f3421h = 2;
                m3979a(1);
            case C0268R.styleable.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                this.f3421h = 3;
                m3979a(1);
            case C0268R.styleable.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                this.f3421h = 4;
                m3979a(1);
            case C0268R.styleable.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                m3979a(3);
            default:
                if (this.f3420g != 0) {
                    switch (b) {
                        case C0268R.styleable.AppCompatTheme_actionModeCopyDrawable /*33*/:
                            if (this.f3419f.length() > 0) {
                                this.f3419f.setLength(this.f3419f.length() - 1);
                            }
                        case C0268R.styleable.AppCompatTheme_dialogPreferredPadding /*44*/:
                            this.f3422i = null;
                            if (this.f3420g == 1 || this.f3420g == 3) {
                                this.f3419f.setLength(0);
                            }
                        case C0268R.styleable.AppCompatTheme_listDividerAlertDialog /*45*/:
                            m3990j();
                        case C0268R.styleable.AppCompatTheme_actionDropDownStyle /*46*/:
                            this.f3419f.setLength(0);
                        case C0268R.styleable.AppCompatTheme_dropdownListPreferredItemHeight /*47*/:
                            this.f3422i = m3991k();
                            this.f3419f.setLength(0);
                        default:
                    }
                }
        }
    }

    private void m3989i() {
        if (this.f3419f.length() > 0) {
            this.f3419f.setLength(this.f3419f.length() - 1);
        }
    }

    private void m3990j() {
        int length = this.f3419f.length();
        if (length > 0 && this.f3419f.charAt(length - 1) != '\n') {
            this.f3419f.append('\n');
        }
    }

    private String m3991k() {
        int length = this.f3419f.length();
        if (length == 0) {
            return null;
        }
        int i;
        if (this.f3419f.charAt(length - 1) == '\n') {
            i = 1;
        } else {
            i = 0;
        }
        if (length == 1 && i != 0) {
            return null;
        }
        if (i != 0) {
            length--;
        }
        if (this.f3420g != 1) {
            return this.f3419f.substring(0, length);
        }
        int i2;
        i = length;
        for (i2 = 0; i2 < this.f3421h && i != -1; i2++) {
            i = this.f3419f.lastIndexOf("\n", i - 1);
        }
        if (i != -1) {
            i2 = i + 1;
        } else {
            i2 = 0;
        }
        this.f3419f.delete(0, i2);
        return this.f3419f.substring(0, length - i2);
    }

    private void m3979a(int i) {
        if (this.f3420g != i) {
            this.f3420g = i;
            this.f3419f.setLength(0);
            if (i == 1 || i == 0) {
                this.f3422i = null;
            }
        }
    }

    private static char m3982b(byte b) {
        return (char) f3414a[(b & TransportMediator.KEYCODE_MEDIA_PAUSE) - 32];
    }

    private static char m3984c(byte b) {
        return (char) f3415b[b & 15];
    }

    private static char m3986d(byte b) {
        return (char) f3416c[b & 31];
    }

    private static char m3987e(byte b) {
        return (char) f3417d[b & 31];
    }

    private static boolean m3983b(byte b, byte b2) {
        return (b == 20 || b == 28) && b2 >= 32 && b2 <= 47;
    }

    private static boolean m3985c(byte b, byte b2) {
        return b >= 16 && b <= 31 && b2 >= 64 && b2 <= 127;
    }

    private static boolean m3988f(byte b) {
        return b >= 16 && b <= 31;
    }

    public static boolean m3981a(int i, int i2, ParsableByteArray parsableByteArray) {
        if (i != 4 || i2 < 8) {
            return false;
        }
        int d = parsableByteArray.m4456d();
        int g = parsableByteArray.m4461g();
        int h = parsableByteArray.m4462h();
        int n = parsableByteArray.m4468n();
        int g2 = parsableByteArray.m4461g();
        parsableByteArray.m4455c(d);
        if (g == 181 && h == 49 && n == 1195456820 && g2 == 3) {
            return true;
        }
        return false;
    }
}
