package com.cb.coink.model;

import com.google.gson.annotations.SerializedName;

public class Genders {

    @SerializedName("id")
    private  int id;

    @SerializedName("name")
    private  String name;

    @SerializedName("description")
    private  String description;

    public Genders(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
