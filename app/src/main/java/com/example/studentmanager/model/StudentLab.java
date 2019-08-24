package com.example.studentmanager.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.studentmanager.database.StudentBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class StudentLab {


    private  static StudentLab sStudentLab;
    private List<Student> mStudents;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    private StudentLab(Context context) {

        mContext = context.getApplicationContext();
        mDatabase = new StudentBaseHelper(mContext).getWritableDatabase();  // Initialize the database
        mStudents = new ArrayList<>();



    }


    public static  StudentLab get(Context context){
        if(sStudentLab ==null){
            sStudentLab = new StudentLab(context);
        }
        return sStudentLab;
    }


    public void  addStudent(Student student){

    }

    public List<Student> getStudentList(){
        return  mStudents;
    }

    public void  deleteStudent(Student student){

    }

    public void updateStudent(Student student){

    }


    public  Student getStudentById(int id){

        return null;
    }

}
