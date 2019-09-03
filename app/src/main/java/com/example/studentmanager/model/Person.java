package com.example.studentmanager.model;

import java.util.Date;

public  abstract class Person  {

    private String mName;
    private Date mBirthDate;
    private  String mDni;
    private  boolean mSex;   // If sex==true then male else female
    private String mPhoto;


    public Person(){

    }

    public Person(String name, Date birthDate, String dni, boolean sex, String photo) {
        mName = name;
        mBirthDate = birthDate;
        mDni = dni;
        mSex = sex;
        mPhoto = photo;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Date getBirthDate() {
        return mBirthDate;
    }

    public void setBirthDate(Date birthDate) {
        mBirthDate = birthDate;
    }

    public String getDni() {
        return mDni;
    }

    public void setDni(String dni) {
        mDni = dni;
    }

    public boolean isSex() {
        return mSex;
    }

    public void setSex(boolean sex) {
        mSex = sex;
    }

    public String getPhoto() {
        return mPhoto;
    }

    public void setPhoto(String photo) {
        mPhoto = photo;
    }


}

