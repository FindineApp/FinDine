package com.example.findine.reviews;

public class ReviewItem {
    private String userName;
    private String userDate;
    private String userDescription;
    private double userRate;
    private String userProfilePicture;

    public ReviewItem(String userName, String userDate, String userDescription, double userRate, String userProfilePicture) {
        this.userName = userName;
        this.userDate = userDate;
        this.userDescription = userDescription;
        this.userRate = userRate;
        this.userProfilePicture = userProfilePicture;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserDate() {
        return userDate;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public double getUserRate() {
        return userRate;
    }

    public String getUserProfilePicture() {
        return userProfilePicture;
    }
}

