package com.example.studentmanager.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.studentmanager.database.StudentBaseHelper;
import com.example.studentmanager.database.StudentCursorWrapper;
import com.example.studentmanager.database.StudentDbSchema;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class StudentLab {


    private  static StudentLab sStudentLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    private StudentLab(Context context) {

        mContext = context.getApplicationContext();
        mDatabase = new StudentBaseHelper(mContext).getWritableDatabase();  // Initialize the database




    }


    private  static ContentValues getContentValues(Student s){

        ContentValues values = new ContentValues();


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        String date =  sdf.format(s.getBirthDate());


        values.put(StudentDbSchema.StudentTable.Cols.BIRTH_DATE,date);
        values.put(StudentDbSchema.StudentTable.Cols.CAREER,s.getCareer());
        values.put(StudentDbSchema.StudentTable.Cols.NAME,s.getName());
        values.put(StudentDbSchema.StudentTable.Cols.DNI,s.getDni());
        values.put(StudentDbSchema.StudentTable.Cols.SEX,s.isSex());
        values.put(StudentDbSchema.StudentTable.Cols.PERIOD,s.getPeriod());
        values.put(StudentDbSchema.StudentTable.Cols.UNIVERSITY,s.getUniversity());
        values.put(StudentDbSchema.StudentTable.Cols.GPA,s.getGpa());


            return  values;
    }


    public static  StudentLab get(Context context){
        if(sStudentLab ==null){
            sStudentLab = new StudentLab(context);
        }
        return sStudentLab;
    }


    public void  addStudent(Student student){

        ContentValues values = getContentValues(student);

        mDatabase.insert(StudentDbSchema.StudentTable.NAME,null,values);


    }

    public List<Student> getStudentList(){

        List<Student> students = new ArrayList<>();


        StudentCursorWrapper cursor = queryStudent(null,null);

        try {

            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                students.add(cursor.getStudent());
                cursor.moveToNext();
            }


        }finally {
            cursor.close();
        }


        return  students;
    }

    public void  deleteStudent(Student student){

    }

    public void updateStudent(Student student){

    }


    public  Student getStudentById(int id){

        return null;
    }

    private StudentCursorWrapper queryStudent(String whereClause, String [] whereArgs){

        Cursor cursor = mDatabase.query(StudentDbSchema.StudentTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null




        );

        return  new StudentCursorWrapper(cursor);

    }



}
