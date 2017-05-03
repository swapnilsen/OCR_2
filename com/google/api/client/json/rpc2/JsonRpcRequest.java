package com.google.api.client.json.rpc2;

import com.google.api.client.p082b.GenericData;
import com.google.api.client.p082b.Key;

public class JsonRpcRequest extends GenericData {
    @Key
    private Object id;
    @Key
    private final String jsonrpc;
    @Key
    private String method;
    @Key
    private Object params;

    public JsonRpcRequest() {
        this.jsonrpc = "2.0";
    }

    public String getVersion() {
        return "2.0";
    }

    public Object getId() {
        return this.id;
    }

    public void setId(Object obj) {
        this.id = obj;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public Object getParameters() {
        return this.params;
    }

    public void setParameters(Object obj) {
        this.params = obj;
    }

    public JsonRpcRequest set(String str, Object obj) {
        return (JsonRpcRequest) super.set(str, obj);
    }

    public JsonRpcRequest clone() {
        return (JsonRpcRequest) super.clone();
    }
}
