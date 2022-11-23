package com.example.signup;

import android.graphics.Bitmap;

public class matchingDTO {
    //데이터를 담아주기위한 클래스
    private String userID;
    private String userName;
    private String userGender;
    private String lovation_work;
    private String Ucareer;
    private String Ulicense;
    private String uworkTime;
    private Bitmap img;
    //데이터를 담기 위한 getter , setter 선언
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

    public String getLovation_work() {
        return lovation_work;
    }

    public void setLovation_work(String lovation_work) {
        this.lovation_work = lovation_work;
    }

    public String getUcareer() {
        return Ucareer;
    }

    public void setUcareer(String ucareer) {
        Ucareer = ucareer;
    }

    public String getUlicense() {
        return Ulicense;
    }

    public void setUlicense(String ulicense) {
        Ulicense = ulicense;
    }

    public String getUworkTime() {
        return uworkTime;
    }

    public void setUworkTime(String uworkTime) {
        this.uworkTime = uworkTime;
    }


    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "matchingDTO{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", userGender='" + userGender + '\'' +
                ", lovation_work='" + lovation_work + '\'' +
                ", Ucareer='" + Ucareer + '\'' +
                ", Ulicense='" + Ulicense + '\'' +
                ", uworkTime='" + uworkTime + '\'' +
                ", img=" + img +
                '}';
    }
}
