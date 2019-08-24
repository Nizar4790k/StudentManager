package com.example.studentmanager.model;

import java.util.Date;

public  abstract class Person  {

    private String mName;
    private Date mBornDate;
    private  String mDni;
    private  boolean mSex;   // If sex==true then male else female
    private String mPhoto;


    public Person(String name, Date bornDate, String dni, boolean sex, String photo) {
        mName = name;
        mBornDate = bornDate;
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

    public Date getBornDate() {
        return mBornDate;
    }

    public void setBornDate(Date bornDate) {
        mBornDate = bornDate;
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

