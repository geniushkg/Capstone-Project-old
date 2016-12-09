package com.hardikgoswami.githubmetrics.network;

/**
 * Created by geniushkg on 12/9/2016.
 */

public class Contribution {
    private String nameOfRepo;
    private int stars;
    private boolean fork;
    public Contribution() {
    }


    public Contribution(String nameOfRepo, int stars, boolean fork) {
        this.nameOfRepo = nameOfRepo;
        this.stars = stars;
        this.fork = fork;
    }

    public String getNameOfRepo() {
        return nameOfRepo;
    }

    public void setNameOfRepo(String nameOfRepo) {
        this.nameOfRepo = nameOfRepo;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

}
