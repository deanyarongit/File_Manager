package com.perfecto.fm.Api;


public class ApiFile {

    private String name;
   private String date;
   private String pdira;
    private long size;

    public String getPdira() {
        return pdira;
    }

    public void setPdira(String pdira) {
        this.pdira = pdira;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }


}
