package com.example.studentmanager.model.model;

import java.util.List;

public class StudentLab {


    private  static StudentLab sStudentLab;
    private List<Student> mStudents;

    private StudentLab() {



    }


    public static  StudentLab get(){
        if(sStudentLab ==null){
            sStudentLab = new StudentLab();
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
