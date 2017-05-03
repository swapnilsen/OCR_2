package com.google.android.exoplayer2.p060e.p061a;

import android.support.v4.view.MotionEventCompat;
import com.google.android.exoplayer2.p050j.ParsableByteArray;
import com.google.android.exoplayer2.p060e.MetadataDecoder;
import com.google.android.exoplayer2.p060e.MetadataDecoderException;
import com.google.firebase.messaging.SendException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.nend.android.NendAdIconLayout;
import net.nend.android.NendIconError;

/* renamed from: com.google.android.exoplayer2.e.a.d */
public final class Id3Decoder implements MetadataDecoder<List<Id3Frame>> {
    public /* synthetic */ Object m3827a(byte[] bArr, int i) {
        return m3829b(bArr, i);
    }

    public boolean m3828a(String str) {
        return str.equals("application/id3");
    }

    public List<Id3Frame> m3829b(byte[] bArr, int i) {
        List arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        int a = Id3Decoder.m3817a(parsableByteArray);
        while (a > 0) {
            int g = parsableByteArray.m4461g();
            int g2 = parsableByteArray.m4461g();
            int g3 = parsableByteArray.m4461g();
            int g4 = parsableByteArray.m4461g();
            int s = parsableByteArray.m4473s();
            if (s <= 1) {
                break;
            }
            Object a2;
            parsableByteArray.m4457d(2);
            if (g == 84 && g2 == 88 && g3 == 88 && g4 == 88) {
                try {
                    a2 = Id3Decoder.m3820a(parsableByteArray, s);
                } catch (Throwable e) {
                    throw new MetadataDecoderException("Unsupported encoding", e);
                }
            } else if (g == 80 && g2 == 82 && g3 == 73 && g4 == 86) {
                a2 = Id3Decoder.m3822b(parsableByteArray, s);
            } else if (g == 71 && g2 == 69 && g3 == 79 && g4 == 66) {
                a2 = Id3Decoder.m3825c(parsableByteArray, s);
            } else if (g == 65 && g2 == 80 && g3 == 73 && g4 == 67) {
                a2 = Id3Decoder.m3826d(parsableByteArray, s);
            } else if (g == 84) {
                a2 = Id3Decoder.m3819a(parsableByteArray, s, String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(g), Integer.valueOf(g2), Integer.valueOf(g3), Integer.valueOf(g4)}));
            } else {
                a2 = Id3Decoder.m3821b(parsableByteArray, s, String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(g), Integer.valueOf(g2), Integer.valueOf(g3), Integer.valueOf(g4)}));
            }
            arrayList.add(a2);
            a -= s + 10;
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static int m3818a(byte[] bArr, int i, int i2) {
        int c = Id3Decoder.m3824c(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return c;
        }
        while (c < bArr.length - 1) {
            if (c % 2 == 0 && bArr[c + 1] == null) {
                return c;
            }
            c = Id3Decoder.m3824c(bArr, c + 1);
        }
        return bArr.length;
    }

    private static int m3824c(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == null) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    private static int m3816a(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static int m3817a(ParsableByteArray parsableByteArray) {
        int g = parsableByteArray.m4461g();
        int g2 = parsableByteArray.m4461g();
        int g3 = parsableByteArray.m4461g();
        if (g == 73 && g2 == 68 && g3 == 51) {
            parsableByteArray.m4457d(2);
            g2 = parsableByteArray.m4461g();
            g = parsableByteArray.m4473s();
            if ((g2 & 2) != 0) {
                g3 = parsableByteArray.m4473s();
                if (g3 > 4) {
                    parsableByteArray.m4457d(g3 - 4);
                }
                g -= g3;
            }
            if ((g2 & 8) != 0) {
                return g - 10;
            }
            return g;
        }
        throw new MetadataDecoderException(String.format(Locale.US, "Unexpected ID3 file identifier, expected \"ID3\", actual \"%c%c%c\".", new Object[]{Integer.valueOf(g), Integer.valueOf(g2), Integer.valueOf(g3)}));
    }

    private static TxxxFrame m3820a(ParsableByteArray parsableByteArray, int i) {
        int g = parsableByteArray.m4461g();
        String b = Id3Decoder.m3823b(g);
        byte[] bArr = new byte[(i - 1)];
        parsableByteArray.m4451a(bArr, 0, i - 1);
        int a = Id3Decoder.m3818a(bArr, 0, g);
        String str = new String(bArr, 0, a, b);
        a += Id3Decoder.m3816a(g);
        return new TxxxFrame(str, new String(bArr, a, Id3Decoder.m3818a(bArr, a, g) - a, b));
    }

    private static PrivFrame m3822b(ParsableByteArray parsableByteArray, int i) {
        byte[] bArr = new byte[i];
        parsableByteArray.m4451a(bArr, 0, i);
        int c = Id3Decoder.m3824c(bArr, 0);
        return new PrivFrame(new String(bArr, 0, c, "ISO-8859-1"), Arrays.copyOfRange(bArr, c + 1, bArr.length));
    }

    private static GeobFrame m3825c(ParsableByteArray parsableByteArray, int i) {
        int g = parsableByteArray.m4461g();
        String b = Id3Decoder.m3823b(g);
        byte[] bArr = new byte[(i - 1)];
        parsableByteArray.m4451a(bArr, 0, i - 1);
        int c = Id3Decoder.m3824c(bArr, 0);
        String str = new String(bArr, 0, c, "ISO-8859-1");
        c++;
        int a = Id3Decoder.m3818a(bArr, c, g);
        String str2 = new String(bArr, c, a - c, b);
        c = Id3Decoder.m3816a(g) + a;
        a = Id3Decoder.m3818a(bArr, c, g);
        return new GeobFrame(str, str2, new String(bArr, c, a - c, b), Arrays.copyOfRange(bArr, Id3Decoder.m3816a(g) + a, bArr.length));
    }

    private static ApicFrame m3826d(ParsableByteArray parsableByteArray, int i) {
        int g = parsableByteArray.m4461g();
        String b = Id3Decoder.m3823b(g);
        byte[] bArr = new byte[(i - 1)];
        parsableByteArray.m4451a(bArr, 0, i - 1);
        int c = Id3Decoder.m3824c(bArr, 0);
        String str = new String(bArr, 0, c, "ISO-8859-1");
        int i2 = bArr[c + 1] & MotionEventCompat.ACTION_MASK;
        c += 2;
        int a = Id3Decoder.m3818a(bArr, c, g);
        return new ApicFrame(str, new String(bArr, c, a - c, b), i2, Arrays.copyOfRange(bArr, Id3Decoder.m3816a(g) + a, bArr.length));
    }

    private static TextInformationFrame m3819a(ParsableByteArray parsableByteArray, int i, String str) {
        int g = parsableByteArray.m4461g();
        String b = Id3Decoder.m3823b(g);
        byte[] bArr = new byte[(i - 1)];
        parsableByteArray.m4451a(bArr, 0, i - 1);
        return new TextInformationFrame(str, new String(bArr, 0, Id3Decoder.m3818a(bArr, 0, g), b));
    }

    private static BinaryFrame m3821b(ParsableByteArray parsableByteArray, int i, String str) {
        byte[] bArr = new byte[i];
        parsableByteArray.m4451a(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    private static String m3823b(int i) {
        switch (i) {
            case NendAdIconLayout.HORIZONTAL /*0*/:
                return "ISO-8859-1";
            case NendIconError.ERROR_ICONVIEW /*1*/:
                return "UTF-16";
            case FirebaseRemoteConfig.VALUE_SOURCE_REMOTE /*2*/:
                return "UTF-16BE";
            case SendException.ERROR_TTL_EXCEEDED /*3*/:
                return "UTF-8";
            default:
                return "ISO-8859-1";
        }
    }
}
