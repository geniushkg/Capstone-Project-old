package com.hardikgoswami.githubmetrics.network;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by geniushkg on 12/9/2016.
 */

public class UserData {

    private boolean isValid;
    private String location;
    private String bio;
    private String imageUrl;
    private String email;
    private float rating;
    private int numOfContributionAnnually;
    private int followers;
    private List<Contribution> repoList;

    public UserData() {
        repoList = new ArrayList<Contribution>();
    }

    public UserData(boolean isValid, String location,
                    String bio, String imageUrl, String email, float rating,
                    int numOfContributionAnnually, int followers, List<Contribution> repoList) {
        repoList = new ArrayList<Contribution>();
        this.isValid = isValid;
        this.location = location;
        this.bio = bio;
        this.imageUrl = imageUrl;
        this.email = email;
        this.rating = rating;
        this.numOfContributionAnnually = numOfContributionAnnually;
        this.followers = followers;
        this.repoList = repoList;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public int getNumOfContributionAnnually() {
        return numOfContributionAnnually;
    }

    public void setNumOfContributionAnnually(int numOfContributionAnnually) {
        this.numOfContributionAnnually = numOfContributionAnnually;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public List<Contribution> getRepoList() {
        return repoList;
    }

    public void setRepoList(List<Contribution> repoList) {
        this.repoList = repoList;
    }
}
