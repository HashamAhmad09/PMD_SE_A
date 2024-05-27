package com.example.myapplication.RestAPI;

public class MyRestAPiModel {
    private float userId;
    private float id;
    private String title;
    private String body;


    // Getter Methods

    public float getUserId() {
        return userId;
    }

    public float getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public MyRestAPiModel(float userId, float id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    // Setter Methods

    public void setUserId(float userId) {
        this.userId = userId;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
