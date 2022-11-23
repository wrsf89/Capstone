package com.example.signup;
public class UserData {
    private String userID;
    private String userName;
    private String userGender;
    private String lovation_work;
    private String Ucareer;
    private String Ulicense;

    public String getuserID() {
        return userID;
    }

    public String getuserName() {
        return userName;
    }

    public String getuserGender() {
        return userGender;
    }

    public String getlovation_work() {
        return lovation_work;
    }

    public String getUcareer() {
        return Ucareer;
    }

    public String getUlicense() {
        return Ulicense;
    }

    public void setuserID(String userID) {
        this.userID = userID;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public void setuserGender(String userGender) {
        this.userGender = userGender;
    }

    public void setlovation_work(String lovation_work) {
        this.lovation_work = lovation_work;
    }

    public void setUcareer(String Ucareer) {
        this.Ucareer = Ucareer;
    }

    public void setUlicense(String Ulicense) {
        this.Ulicense = Ulicense;
    }

}
