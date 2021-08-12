package com.cieep.ejercicio01_retrofit.models;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("category_id")
    private long categoryID;
    private String name;
    private String nicename;

    public long getCategoryID()
    { return categoryID; }
    public void setCategoryID(long value) { this.categoryID = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getNicename() { return nicename; }
    public void setNicename(String value) { this.nicename = value; }

}
