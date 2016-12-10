package com.hardikgoswami.githubmetrics.network;

/**
 * Created by geniushkg on 12/9/2016.
 */

public class User {
    private int id;
    private String location;
    private String email;
    private String bio;
    private int followers;
    private String avatar_url;

    public User() {
    }

    public User(int id, String location, String email, String bio, int followers, String avatar_url) {
        this.id = id;
        this.location = location;
        this.email = email;
        this.bio = bio;
        this.followers = followers;
        this.avatar_url = avatar_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
