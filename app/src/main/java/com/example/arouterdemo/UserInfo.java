package com.example.arouterdemo;

import java.io.Serializable;

public class UserInfo implements Serializable {
    public int sex;
    public String homeAddress;
    public String phoneNumber;
    public String IDCardNumber;

    public UserInfo(int sex, String homeAddress, String phoneNumber, String IDCardNumber) {
        this.sex = sex;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
        this.IDCardNumber = IDCardNumber;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIDCardNumber() {
        return IDCardNumber;
    }

    public void setIDCardNumber(String IDCardNumber) {
        this.IDCardNumber = IDCardNumber;
    }
}
