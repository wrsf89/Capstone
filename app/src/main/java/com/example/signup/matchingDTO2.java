package com.example.signup;

import android.graphics.Bitmap;

public class matchingDTO2 {
    private String userID;
    private String userName;
    private String userGender;
    private String diseaseName;
    private String location_check;
    private String note;
    private String time;
    private Bitmap img;
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getLocation_check() {
        return location_check;
    }

    public void setLocation_check(String location_check) {
        this.location_check = location_check;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "matchingDTO2{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", userGender='" + userGender + '\'' +
                ", diseaseName='" + diseaseName + '\'' +
                ", location_check='" + location_check + '\'' +
                ", note='" + note + '\'' +
                ", time='" + time + '\'' +
                ", img=" + img +
                '}';
    }
}
