package com.facebook.ads.internal.p021m;

import android.content.Context;
import android.support.annotation.WorkerThread;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.Log;
import com.facebook.ads.internal.p025h.C0589p;
import com.facebook.ads.internal.p031g.C0562g;
import com.facebook.ads.internal.p031g.C0564i;
import com.google.ads.mediation.facebook.FacebookAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.m.ab */
public class ab {
    private static final String f1566a;
    private static final Object f1567b;

    static {
        f1566a = ab.class.getName();
        f1567b = new Object();
    }

    public static C0589p m2132a(Exception exception, Context context) {
        C0589p c0589p = new C0589p(C0562g.m1744b(), C0562g.m1745c(), new aa(C0692g.m2252a(exception), C0564i.f1304f, true));
        ab.m2135a(c0589p, context);
        return c0589p;
    }

    @WorkerThread
    public static JSONArray m2133a(Context context) {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable e;
        InputStreamReader inputStreamReader2;
        FileInputStream fileInputStream;
        BufferedReader bufferedReader2 = null;
        JSONArray jSONArray = new JSONArray();
        synchronized (f1567b) {
            FileInputStream openFileInput;
            try {
                if (new File(context.getFilesDir(), "crasheslog").exists()) {
                    openFileInput = context.openFileInput("crasheslog");
                    try {
                        inputStreamReader = new InputStreamReader(openFileInput);
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                            while (true) {
                                try {
                                    String readLine = bufferedReader.readLine();
                                    if (readLine == null) {
                                        break;
                                    }
                                    jSONArray.put(new JSONObject(readLine));
                                } catch (Exception e2) {
                                    e = e2;
                                    inputStreamReader2 = inputStreamReader;
                                    fileInputStream = openFileInput;
                                } catch (Throwable th) {
                                    e = th;
                                    bufferedReader2 = bufferedReader;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            bufferedReader = null;
                            inputStreamReader2 = inputStreamReader;
                            fileInputStream = openFileInput;
                            try {
                                Log.e(f1566a, "Failed to read crashes", e);
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable e4) {
                                        Log.e(f1566a, "Failed to close buffers", e4);
                                    }
                                }
                                if (inputStreamReader2 != null) {
                                    inputStreamReader2.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return jSONArray;
                            } catch (Throwable th2) {
                                e4 = th2;
                                openFileInput = fileInputStream;
                                inputStreamReader = inputStreamReader2;
                                bufferedReader2 = bufferedReader;
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (Throwable e5) {
                                        Log.e(f1566a, "Failed to close buffers", e5);
                                        throw e4;
                                    }
                                }
                                if (inputStreamReader != null) {
                                    inputStreamReader.close();
                                }
                                if (openFileInput != null) {
                                    openFileInput.close();
                                }
                                throw e4;
                            }
                        } catch (Throwable th3) {
                            e4 = th3;
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (openFileInput != null) {
                                openFileInput.close();
                            }
                            throw e4;
                        }
                    } catch (Exception e6) {
                        e4 = e6;
                        bufferedReader = null;
                        fileInputStream = openFileInput;
                        Log.e(f1566a, "Failed to read crashes", e4);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        if (inputStreamReader2 != null) {
                            inputStreamReader2.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return jSONArray;
                    } catch (Throwable th4) {
                        e4 = th4;
                        inputStreamReader = null;
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (openFileInput != null) {
                            openFileInput.close();
                        }
                        throw e4;
                    }
                }
                bufferedReader = null;
                inputStreamReader = null;
                openFileInput = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e42) {
                        Log.e(f1566a, "Failed to close buffers", e42);
                    }
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (openFileInput != null) {
                    openFileInput.close();
                }
            } catch (Exception e7) {
                e42 = e7;
                bufferedReader = null;
                fileInputStream = null;
                Log.e(f1566a, "Failed to read crashes", e42);
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStreamReader2 != null) {
                    inputStreamReader2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return jSONArray;
            } catch (Throwable th5) {
                e42 = th5;
                inputStreamReader = null;
                openFileInput = null;
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (openFileInput != null) {
                    openFileInput.close();
                }
                throw e42;
            }
        }
        return jSONArray;
    }

    private static JSONObject m2134a(C0589p c0589p) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(FacebookAdapter.KEY_ID, UUID.randomUUID().toString());
        jSONObject.put("type", c0589p.m1841b());
        jSONObject.put("time", C0712u.m2296a(c0589p.m1759e()));
        jSONObject.put("session_time", C0712u.m2296a(c0589p.m1760f()));
        jSONObject.put("session_id", c0589p.m1761g());
        jSONObject.put("data", c0589p.m1762h() != null ? new JSONObject(c0589p.m1762h()) : new JSONObject());
        return jSONObject;
    }

    public static void m2135a(C0589p c0589p, Context context) {
        if (c0589p != null && context != null) {
            synchronized (f1567b) {
                try {
                    JSONObject a = ab.m2134a(c0589p);
                    FileOutputStream openFileOutput = context.openFileOutput("crasheslog", AccessibilityNodeInfoCompat.ACTION_PASTE);
                    openFileOutput.write((a.toString() + "\n").getBytes());
                    openFileOutput.close();
                } catch (Throwable e) {
                    Log.e(f1566a, "Failed to store crash", e);
                }
            }
        }
    }

    @WorkerThread
    public static void m2136b(Context context) {
        synchronized (f1567b) {
            File file = new File(context.getFilesDir(), "crasheslog");
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
