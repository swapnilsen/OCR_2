package com.google.api.services.vision.v1.model;

import com.google.api.client.json.GenericJson;
import com.google.api.client.p082b.Data;
import com.google.api.client.p082b.Key;
import java.util.List;

public final class BoundingPoly extends GenericJson {
    @Key
    private List<Vertex> vertices;

    static {
        Data.m4898a(Vertex.class);
    }

    public List<Vertex> getVertices() {
        return this.vertices;
    }

    public BoundingPoly setVertices(List<Vertex> list) {
        this.vertices = list;
        return this;
    }

    public BoundingPoly set(String str, Object obj) {
        return (BoundingPoly) super.set(str, obj);
    }

    public BoundingPoly clone() {
        return (BoundingPoly) super.clone();
    }
}
