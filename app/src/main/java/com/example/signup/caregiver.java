package com.example.signup;

public class caregiver {
    String signID;
    String career; //경력
    String workTime; //일하는시간
    String license; //자격증
    String location_work; //자택간병 , 병원간병 선택
    String info2_rating; //간병 등급

    public caregiver(){

    }


    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLocation_work() {
        return location_work;
    }

    public void setLocation_work(String location_work) {
        this.location_work = location_work;
    }

    public String getSignID() {
        return signID;
    }

    public void setSignID(String signID) {
        this.signID = signID;
    }

    public String getInfo2_rating() {
        return info2_rating;
    }

    public void setInfo2_rating(String info2_rating) {
        this.info2_rating = info2_rating;
    }

    @Override
    public String toString() {
        return "caregiver{" +
                "signID='" + signID + '\'' +
                ", career='" + career + '\'' +
                ", workTime='" + workTime + '\'' +
                ", license='" + license + '\'' +
                ", location_work='" + location_work + '\'' +
                ", info2_rating='" + info2_rating + '\'' +
                '}';
    }

    public caregiver(String signID , String career, String workTime, String license, String location_work,String info2_rating){
        this.signID = signID;
        this.career = career;
        this.workTime = workTime;
        this.license = license;
        this.location_work = location_work;
        this.info2_rating = info2_rating;
    }

}
