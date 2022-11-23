package com.example.signup;

public class member {

    String signName; //이름
    String gender; //성별
    String phoneNb;
    String signAddress;
    String serviceId; //간병인,환자 서비스 체크
    String signmail; //이메일
    String signID; //아이디
    String signBirth; //년
    String signBirth2; //월
    String signBirth3; //일
    String signPW; //비밀번호
    String signPW2; //비밀번호 확인
    String img;
    public member(){

    }


    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public String getPhoneNb() {
        return phoneNb;
    }

    public void setPhoneNb(String phoneNb) {
        this.phoneNb = phoneNb;
    }

    public String getSignAddress() {
        return signAddress;
    }

    public void setSignAddress(String signAddress) {
        this.signAddress = signAddress;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getSignmail() {
        return signmail;
    }

    public void setSignmail(String signmail) {
        this.signmail = signmail;
    }

    public String getSignID() {
        return signID;
    }

    public void setSignID(String signID) {
        this.signID = signID;
    }

    public String getSignBirth() {
        return signBirth;
    }

    public void setSignBirth(String signBirth) {
        this.signBirth = signBirth;
    }

    public String getSignBirth2() {
        return signBirth2;
    }

    public void setSignBirth2(String signBirth2) {
        this.signBirth2 = signBirth2;
    }

    public String getSignBirth3() {
        return signBirth3;
    }

    public void setSignBirth3(String signBirth3) {
        this.signBirth3 = signBirth3;
    }

    public String getSignPW() {
        return signPW;
    }

    public void setSignPW(String signPW) {
        this.signPW = signPW;
    }

    public String getSignPW2() {
        return signPW2;
    }

    public void setSignPW2(String signPw2) {
        this.signPW2 = signPW2;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "member{" +
                "signName='" + signName + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNb='" + phoneNb + '\'' +
                ", signAddress='" + signAddress + '\'' +
                ", serviceId='" + serviceId + '\'' +
                ", signmail='" + signmail + '\'' +
                ", signID='" + signID + '\'' +
                ", signBirth='" + signBirth + '\'' +
                ", signBirth2='" + signBirth2 + '\'' +
                ", signBirth3='" + signBirth3 + '\'' +
                ", signPW='" + signPW + '\'' +
                ", signPW2='" + signPW2 + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
