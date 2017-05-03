package com.google.api.client.googleapis.json;

import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpResponseException.Builder;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.p082b.Preconditions;
import com.google.api.client.p082b.af;
import com.google.api.client.p082b.ag;
import java.io.IOException;

public class GoogleJsonResponseException extends HttpResponseException {
    private final transient GoogleJsonError f4310a;

    public GoogleJsonResponseException(Builder builder, GoogleJsonError googleJsonError) {
        super(builder);
        this.f4310a = googleJsonError;
    }

    public final GoogleJsonError getDetails() {
        return this.f4310a;
    }

    public static GoogleJsonResponseException from(JsonFactory jsonFactory, HttpResponse httpResponse) {
        String parseAsString;
        StringBuilder computeMessageBuffer;
        JsonParser createJsonParser;
        GoogleJsonError googleJsonError;
        IOException e;
        GoogleJsonError googleJsonError2;
        Object obj;
        GoogleJsonError googleJsonError3;
        Throwable th;
        GoogleJsonError googleJsonError4 = null;
        Builder builder = new Builder(httpResponse.getStatusCode(), httpResponse.getStatusMessage(), httpResponse.getHeaders());
        Preconditions.m4968a((Object) jsonFactory);
        try {
            if (httpResponse.isSuccessStatusCode() || !HttpMediaType.equalsIgnoreParameters(Json.MEDIA_TYPE, httpResponse.getContentType()) || httpResponse.getContent() == null) {
                parseAsString = httpResponse.parseAsString();
                computeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
                if (!ag.m4858a(parseAsString)) {
                    computeMessageBuffer.append(af.f4124a).append(parseAsString);
                    builder.setContent(parseAsString);
                }
                builder.setMessage(computeMessageBuffer.toString());
                return new GoogleJsonResponseException(builder, googleJsonError4);
            }
            try {
                createJsonParser = jsonFactory.createJsonParser(httpResponse.getContent());
                try {
                    JsonToken currentToken = createJsonParser.getCurrentToken();
                    if (currentToken == null) {
                        currentToken = createJsonParser.nextToken();
                    }
                    if (currentToken != null) {
                        createJsonParser.skipToKey("error");
                        if (createJsonParser.getCurrentToken() != JsonToken.END_OBJECT) {
                            googleJsonError = (GoogleJsonError) createJsonParser.parseAndClose(GoogleJsonError.class);
                            try {
                                googleJsonError4 = googleJsonError;
                                parseAsString = googleJsonError.toPrettyString();
                                if (createJsonParser != null) {
                                    try {
                                        httpResponse.ignore();
                                    } catch (IOException e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        computeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
                                        if (ag.m4858a(parseAsString)) {
                                            computeMessageBuffer.append(af.f4124a).append(parseAsString);
                                            builder.setContent(parseAsString);
                                        }
                                        builder.setMessage(computeMessageBuffer.toString());
                                        return new GoogleJsonResponseException(builder, googleJsonError4);
                                    }
                                    computeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
                                    if (ag.m4858a(parseAsString)) {
                                        computeMessageBuffer.append(af.f4124a).append(parseAsString);
                                        builder.setContent(parseAsString);
                                    }
                                    builder.setMessage(computeMessageBuffer.toString());
                                    return new GoogleJsonResponseException(builder, googleJsonError4);
                                }
                                if (googleJsonError4 == null) {
                                    createJsonParser.close();
                                }
                                computeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
                                if (ag.m4858a(parseAsString)) {
                                    computeMessageBuffer.append(af.f4124a).append(parseAsString);
                                    builder.setContent(parseAsString);
                                }
                                builder.setMessage(computeMessageBuffer.toString());
                                return new GoogleJsonResponseException(builder, googleJsonError4);
                            } catch (IOException e3) {
                                e = e3;
                                try {
                                    e.printStackTrace();
                                    if (createJsonParser != null) {
                                        try {
                                            httpResponse.ignore();
                                            googleJsonError2 = googleJsonError4;
                                            googleJsonError4 = googleJsonError;
                                            obj = googleJsonError2;
                                        } catch (IOException e4) {
                                            e = e4;
                                            googleJsonError2 = googleJsonError4;
                                            googleJsonError4 = googleJsonError;
                                            obj = googleJsonError2;
                                            e.printStackTrace();
                                            computeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
                                            if (ag.m4858a(parseAsString)) {
                                                computeMessageBuffer.append(af.f4124a).append(parseAsString);
                                                builder.setContent(parseAsString);
                                            }
                                            builder.setMessage(computeMessageBuffer.toString());
                                            return new GoogleJsonResponseException(builder, googleJsonError4);
                                        }
                                    } else if (googleJsonError == null) {
                                        createJsonParser.close();
                                        googleJsonError2 = googleJsonError4;
                                        googleJsonError4 = googleJsonError;
                                        obj = googleJsonError2;
                                    } else {
                                        googleJsonError2 = googleJsonError4;
                                        googleJsonError4 = googleJsonError;
                                        obj = googleJsonError2;
                                    }
                                    computeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
                                    if (ag.m4858a(parseAsString)) {
                                        computeMessageBuffer.append(af.f4124a).append(parseAsString);
                                        builder.setContent(parseAsString);
                                    }
                                    builder.setMessage(computeMessageBuffer.toString());
                                    return new GoogleJsonResponseException(builder, googleJsonError4);
                                } catch (Throwable th2) {
                                    Throwable th3 = th2;
                                    googleJsonError3 = googleJsonError;
                                    th = th3;
                                    if (createJsonParser != null) {
                                        try {
                                            httpResponse.ignore();
                                        } catch (IOException e5) {
                                            IOException iOException = e5;
                                            obj = googleJsonError4;
                                            googleJsonError4 = googleJsonError3;
                                            e = iOException;
                                            e.printStackTrace();
                                            computeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
                                            if (ag.m4858a(parseAsString)) {
                                                computeMessageBuffer.append(af.f4124a).append(parseAsString);
                                                builder.setContent(parseAsString);
                                            }
                                            builder.setMessage(computeMessageBuffer.toString());
                                            return new GoogleJsonResponseException(builder, googleJsonError4);
                                        }
                                    } else if (googleJsonError3 == null) {
                                        createJsonParser.close();
                                    }
                                    throw th;
                                }
                            }
                        }
                    }
                    obj = googleJsonError4;
                    if (createJsonParser != null) {
                        if (googleJsonError4 == null) {
                            createJsonParser.close();
                        }
                        computeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
                        if (ag.m4858a(parseAsString)) {
                            computeMessageBuffer.append(af.f4124a).append(parseAsString);
                            builder.setContent(parseAsString);
                        }
                        builder.setMessage(computeMessageBuffer.toString());
                        return new GoogleJsonResponseException(builder, googleJsonError4);
                    }
                    httpResponse.ignore();
                    computeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
                    if (ag.m4858a(parseAsString)) {
                        computeMessageBuffer.append(af.f4124a).append(parseAsString);
                        builder.setContent(parseAsString);
                    }
                    builder.setMessage(computeMessageBuffer.toString());
                    return new GoogleJsonResponseException(builder, googleJsonError4);
                } catch (IOException e52) {
                    e = e52;
                    googleJsonError = googleJsonError4;
                    e.printStackTrace();
                    if (createJsonParser != null) {
                        httpResponse.ignore();
                        googleJsonError2 = googleJsonError4;
                        googleJsonError4 = googleJsonError;
                        obj = googleJsonError2;
                    } else if (googleJsonError == null) {
                        createJsonParser.close();
                        googleJsonError2 = googleJsonError4;
                        googleJsonError4 = googleJsonError;
                        obj = googleJsonError2;
                    } else {
                        googleJsonError2 = googleJsonError4;
                        googleJsonError4 = googleJsonError;
                        obj = googleJsonError2;
                    }
                    computeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
                    if (ag.m4858a(parseAsString)) {
                        computeMessageBuffer.append(af.f4124a).append(parseAsString);
                        builder.setContent(parseAsString);
                    }
                    builder.setMessage(computeMessageBuffer.toString());
                    return new GoogleJsonResponseException(builder, googleJsonError4);
                } catch (Throwable th4) {
                    th = th4;
                    googleJsonError3 = googleJsonError4;
                    if (createJsonParser != null) {
                        httpResponse.ignore();
                    } else if (googleJsonError3 == null) {
                        createJsonParser.close();
                    }
                    throw th;
                }
            } catch (IOException e522) {
                e = e522;
                createJsonParser = googleJsonError4;
                googleJsonError = googleJsonError4;
                e.printStackTrace();
                if (createJsonParser != null) {
                    httpResponse.ignore();
                    googleJsonError2 = googleJsonError4;
                    googleJsonError4 = googleJsonError;
                    obj = googleJsonError2;
                } else if (googleJsonError == null) {
                    googleJsonError2 = googleJsonError4;
                    googleJsonError4 = googleJsonError;
                    obj = googleJsonError2;
                } else {
                    createJsonParser.close();
                    googleJsonError2 = googleJsonError4;
                    googleJsonError4 = googleJsonError;
                    obj = googleJsonError2;
                }
                computeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
                if (ag.m4858a(parseAsString)) {
                    computeMessageBuffer.append(af.f4124a).append(parseAsString);
                    builder.setContent(parseAsString);
                }
                builder.setMessage(computeMessageBuffer.toString());
                return new GoogleJsonResponseException(builder, googleJsonError4);
            } catch (Throwable th5) {
                th = th5;
                createJsonParser = googleJsonError4;
                googleJsonError3 = googleJsonError4;
                if (createJsonParser != null) {
                    httpResponse.ignore();
                } else if (googleJsonError3 == null) {
                    createJsonParser.close();
                }
                throw th;
            }
        } catch (IOException e5222) {
            e = e5222;
            obj = googleJsonError4;
            e.printStackTrace();
            computeMessageBuffer = HttpResponseException.computeMessageBuffer(httpResponse);
            if (ag.m4858a(parseAsString)) {
                computeMessageBuffer.append(af.f4124a).append(parseAsString);
                builder.setContent(parseAsString);
            }
            builder.setMessage(computeMessageBuffer.toString());
            return new GoogleJsonResponseException(builder, googleJsonError4);
        }
    }

    public static HttpResponse execute(JsonFactory jsonFactory, HttpRequest httpRequest) {
        Preconditions.m4968a((Object) jsonFactory);
        boolean throwExceptionOnExecuteError = httpRequest.getThrowExceptionOnExecuteError();
        if (throwExceptionOnExecuteError) {
            httpRequest.setThrowExceptionOnExecuteError(false);
        }
        HttpResponse execute = httpRequest.execute();
        httpRequest.setThrowExceptionOnExecuteError(throwExceptionOnExecuteError);
        if (!throwExceptionOnExecuteError || execute.isSuccessStatusCode()) {
            return execute;
        }
        throw from(jsonFactory, execute);
    }
}
