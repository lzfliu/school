package com.lzf.entity;

import java.io.Serializable;

public class Cas1Relation implements Serializable {
    private String id;

    private String type;

    private String cas1Id;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCas1Id() {
        return cas1Id;
    }

    public void setCas1Id(String cas1Id) {
        this.cas1Id = cas1Id == null ? null : cas1Id.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", cas1Id=").append(cas1Id);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}