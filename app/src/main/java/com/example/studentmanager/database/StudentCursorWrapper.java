package com.example.studentmanager.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.studentmanager.model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentCursorWrapper extends CursorWrapper {

    public StudentCursorWrapper(Cursor cursor) {
        super(cursor);

    }



    public Student getStudent(){
        String dni = getString(getColumnIndex(StudentDbSchema.StudentTable.Cols.DNI));
        String  name = getString(getColumnIndex(StudentDbSchema.StudentTable.Cols.NAME));
        boolean sex = getInt(getColumnIndex(StudentDbSchema.StudentTable.Cols.SEX)) > 0;
        float gpa = getFloat(getColumnIndex(StudentDbSchema.StudentTable.Cols.GPA));
        int period = getInt(getColumnIndex(StudentDbSchema.StudentTable.Cols.PERIOD));
        String university = getString(getColumnIndex(StudentDbSchema.StudentTable.Cols.UNIVERSITY));
        String dateText = getString(getColumnIndex(StudentDbSchema.StudentTable.Cols.BIRTH_DATE));
        String career =getString(getColumnIndex(StudentDbSchema.StudentTable.Cols.CAREER));


        Date date = new Date();
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");



            date=dateFormat.parse(dateText);




        }catch (ParseException e){
            e.printStackTrace();
        }

        Student student = new Student(name,date,dni,sex,null,university,career,period,gpa);



        return student;
    }





}
