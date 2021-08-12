package com.cieep.ejercicio01_retrofit.models;

public class Tag {
    private long tagID;
    private String name;
    private String nicename;

    public long getTagID() { return tagID; }
    public void setTagID(long value) { this.tagID = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getNicename() { return nicename; }
    public void setNicename(String value) { this.nicename = value; }
}
