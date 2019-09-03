package com.example.studentmanager.database;

public class StudentDbSchema  {




    public static final  class  StudentTable{

        public static final String NAME ="students";
        public static final class Cols {                          // Defining a Schema

            public static  final String NAME= "name";
            public static final String BIRTH_DATE ="born_date";
            public static final String SEX="sex";
            public static final String UNIVERSITY="university";
            public static final String CAREER ="career";
            public static final String PERIOD="period";
            public static final String GPA="gpa";
            public static final String DNI="dni";
            public static final String UUID="uuid";


        }
    }



}
