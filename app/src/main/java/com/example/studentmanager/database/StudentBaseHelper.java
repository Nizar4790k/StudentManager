package com.example.studentmanager.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.studentmanager.database.StudentDbSchema.StudentTable;

public class StudentBaseHelper extends SQLiteOpenHelper {

    private  static  final  int VERSION =1;
    private static final String DATABASE_NAME="studentBase.db";




    public StudentBaseHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+StudentDbSchema.StudentTable.NAME +"("+
                "_id integer primary key autoincrement,"+
                StudentTable.Cols.NAME +"," +
                StudentTable.Cols.BIRTH_DATE +","+
                StudentTable.Cols.CAREER+","+
                StudentTable.Cols.SEX+","+
                StudentTable.Cols.PERIOD + "," +
                StudentTable.Cols.GPA+ ","+
                StudentTable.Cols.DNI+","+
                StudentTable.Cols.UNIVERSITY+ ","+
                        StudentTable.Cols.UUID+")"

                );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
