package com.hardikgoswami.githubmetrics.persistence;

/**
 * Created by geniushkg on 12/10/2016.
 */
public class UserHistory {
    private int id;
    private String username;
    private String email;
    private float rating;

    public UserHistory() {
    }

    public UserHistory(int id, String username, String email, float rating) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
