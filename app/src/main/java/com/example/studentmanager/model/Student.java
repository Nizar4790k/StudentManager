package com.example.studentmanager.model;

import java.util.Date;
import java.util.UUID;

public class Student extends  Person {

    private  UUID mId;
    private  String mUniversity;
    private  String mCareer;
    private  int mPeriod;
    private float mGpa;

    public Student(String name, Date bornDate, String dni, boolean sex, String photo, String university, String career, int period,float gpa) {
        super(name, bornDate, dni, sex, photo);
        mId= UUID.randomUUID();
        mUniversity = university;
        mCareer = career;
        mPeriod = period;
        setGpa(gpa);

    }


    public Student(UUID id,String name, Date bornDate, String dni, boolean sex, String photo, String university, String career, int period,float gpa) {
        super(name, bornDate, dni, sex, photo);
        mId= id;
        mUniversity = university;
        mCareer = career;
        mPeriod = period;
        mGpa = gpa;

    }



    public UUID getId() {
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



    public float getGpa() {
        return mGpa;
    }

    public void setGpa(float gpa) {
        mGpa = gpa;
    }






}
