package com.example.myapplication.AltertDialougeExample;

public class My_Model {
    public String Name;
    public int total_Downloads;
    public int thumbnails;

    public int getTotal_Downloads() {
        return total_Downloads;
    }

    public void setTotal_Downloads(int total_Downloads) {
        this.total_Downloads = total_Downloads;
    }

    public int getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(int thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public My_Model(String name, int total_Downloads, int thumbnails) {
        Name = name;
        this.total_Downloads = total_Downloads;
        this.thumbnails = thumbnails;
    }
}
