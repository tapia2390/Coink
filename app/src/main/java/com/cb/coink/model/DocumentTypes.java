package com.cb.coink.model;

import com.google.gson.annotations.SerializedName;

public class DocumentTypes {

    @SerializedName("id")
    private  int id;

    @SerializedName("notation")
    private  String notation;

    @SerializedName("description")
    private  String description;


    public DocumentTypes(int id, String notation, String description) {
        this.id = id;
        this.notation = notation;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNotation() {
        return notation;
    }

    public void setNotation(String notation) {
        this.notation = notation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
