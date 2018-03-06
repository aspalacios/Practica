package com.example.abigailpalacios.practica.models;

/**
 * Created by Abigail Palacios on 27/02/2018.
 */

public class TweetModel {
    String username;
    String text;
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
