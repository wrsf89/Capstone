package com.example.signup;

public class mypageMatchDTO {

    private String userName;
    private String time;
    private String location_work;
    private String ration;
    private String userID;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation_work() {
        return location_work;
    }

    public void setLocation_work(String location_work) {
        this.location_work = location_work;
    }

    public String getRation() {
        return ration;
    }

    public void setRation(String ration) {
        this.ration = ration;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "mypageMatchDTO{" +
                "userName='" + userName + '\'' +
                ", time='" + time + '\'' +
                ", location_work='" + location_work + '\'' +
                ", ration='" + ration + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }
}
