package com.example.signup;

public class meminfo {
    String time; // 원하는 시간
    String diseaseName; // 병명
    String location_check; // 병원간병, 재택간병
    String dementia_check; // 채매여부 확인
    String info_rateing; // 등급
    String note; // 특이사항

    String signID; //이것도 해여해

    public meminfo(){

    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
    public String getDementia_check() {
        return dementia_check;
    }

    public void setDementia_check(String dementia_check) {
        this.dementia_check = dementia_check;
    }

    public String getInfo_rateing() {
        return info_rateing;
    }

    public void setInfo_rateing(String info_rateing) {
        this.info_rateing = info_rateing;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSignID() {
        return signID;
    }

    public void setSignID(String signID) {
        this.signID = signID;
    }

    @Override
    public String toString() {
        return "meminfo{" +
                "time='" + time + '\'' +
                ", diseaseName='" + diseaseName + '\'' +
                ", location_check='" + location_check + '\'' +
                ", dementia_check='" + dementia_check + '\'' +
                ", info_rateing='" + info_rateing + '\'' +
                ", note='" + note + '\'' +
                ", signID='" + signID + '\'' +
                '}';
    }
}
