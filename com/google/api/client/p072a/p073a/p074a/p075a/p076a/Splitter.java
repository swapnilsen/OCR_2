package com.google.api.client.p072a.p073a.p074a.p075a.p076a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.api.client.a.a.a.a.a.e */
public final class Splitter {
    private final CharMatcher f4080a;
    private final boolean f4081b;
    private final Splitter f4082c;
    private final int f4083d;

    /* renamed from: com.google.api.client.a.a.a.a.a.e.a */
    private static abstract class Splitter extends AbstractIterator<String> {
        final CharSequence f4073b;
        final CharMatcher f4074c;
        final boolean f4075d;
        int f4076e;
        int f4077f;

        abstract int m4760a(int i);

        abstract int m4762b(int i);

        protected /* synthetic */ Object m4761a() {
            return m4763c();
        }

        protected Splitter(Splitter splitter, CharSequence charSequence) {
            this.f4076e = 0;
            this.f4074c = splitter.f4080a;
            this.f4075d = splitter.f4081b;
            this.f4077f = splitter.f4083d;
            this.f4073b = charSequence;
        }

        protected String m4763c() {
            int i = this.f4076e;
            while (this.f4076e != -1) {
                int a = m4760a(this.f4076e);
                if (a == -1) {
                    a = this.f4073b.length();
                    this.f4076e = -1;
                } else {
                    this.f4076e = m4762b(a);
                }
                if (this.f4076e == i) {
                    this.f4076e++;
                    if (this.f4076e >= this.f4073b.length()) {
                        this.f4076e = -1;
                    }
                } else {
                    int i2 = i;
                    while (i2 < a && this.f4074c.m4727b(this.f4073b.charAt(i2))) {
                        i2++;
                    }
                    i = a;
                    while (i > i2 && this.f4074c.m4727b(this.f4073b.charAt(i - 1))) {
                        i--;
                    }
                    if (this.f4075d && i2 == i) {
                        i = this.f4076e;
                    } else {
                        if (this.f4077f == 1) {
                            i = this.f4073b.length();
                            this.f4076e = -1;
                            while (i > i2 && this.f4074c.m4727b(this.f4073b.charAt(i - 1))) {
                                i--;
                            }
                        } else {
                            this.f4077f--;
                        }
                        return this.f4073b.subSequence(i2, i).toString();
                    }
                }
            }
            return (String) m4719b();
        }
    }

    /* renamed from: com.google.api.client.a.a.a.a.a.e.b */
    private interface Splitter {
        Iterator<String> m4766b(Splitter splitter, CharSequence charSequence);
    }

    /* renamed from: com.google.api.client.a.a.a.a.a.e.1 */
    static class Splitter implements Splitter {
        final /* synthetic */ CharMatcher f4079a;

        /* renamed from: com.google.api.client.a.a.a.a.a.e.1.1 */
        class Splitter extends Splitter {
            final /* synthetic */ Splitter f4078a;

            Splitter(Splitter splitter, Splitter splitter2, CharSequence charSequence) {
                this.f4078a = splitter;
                super(splitter2, charSequence);
            }

            int m4764a(int i) {
                return this.f4078a.f4079a.m4724a(this.b, i);
            }

            int m4765b(int i) {
                return i + 1;
            }
        }

        Splitter(CharMatcher charMatcher) {
            this.f4079a = charMatcher;
        }

        public /* synthetic */ Iterator m4768b(Splitter splitter, CharSequence charSequence) {
            return m4767a(splitter, charSequence);
        }

        public Splitter m4767a(Splitter splitter, CharSequence charSequence) {
            return new Splitter(this, splitter, charSequence);
        }
    }

    private Splitter(Splitter splitter) {
        this(splitter, false, CharMatcher.f4061m, ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    private Splitter(Splitter splitter, boolean z, CharMatcher charMatcher, int i) {
        this.f4082c = splitter;
        this.f4081b = z;
        this.f4080a = charMatcher;
        this.f4083d = i;
    }

    public static Splitter m4770a(char c) {
        return Splitter.m4771a(CharMatcher.m4720a(c));
    }

    public static Splitter m4771a(CharMatcher charMatcher) {
        Preconditions.m4750a((Object) charMatcher);
        return new Splitter(new Splitter(charMatcher));
    }

    private Iterator<String> m4772b(CharSequence charSequence) {
        return this.f4082c.m4766b(this, charSequence);
    }

    public List<String> m4775a(CharSequence charSequence) {
        Preconditions.m4750a((Object) charSequence);
        Iterator b = m4772b(charSequence);
        List arrayList = new ArrayList();
        while (b.hasNext()) {
            arrayList.add(b.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
