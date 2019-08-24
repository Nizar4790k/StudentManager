package com.example.studentmanager.model;

import java.util.Date;

public class Student extends  Person {

    private int mId;
    private  String mUniversity;
    private  String mCareer;
    private  int mPeriod;
    private double mGpa;

    public Student(String name, Date bornDate, String dni, boolean sex, String photo, String university, String career, int period,double gpa) {
        super(name, bornDate, dni, sex, photo);
        mUniversity = university;
        mCareer = career;
        mPeriod = period;
        mGpa = gpa;

    }

    public int getId() {
        return mId;
    }

    public String getUniversity() {
        return mUniversity;
    }

    public String getCareer() {
        return mCareer;
    }

    public int getPeriod() {
        return mPeriod;
    }

    public void setUniversity(String university) {
        mUniversity = university;
    }

    public void setCareer(String career) {
        mCareer = career;
    }

    public void setPeriod(int period) {
        mPeriod = period;
    }
}
