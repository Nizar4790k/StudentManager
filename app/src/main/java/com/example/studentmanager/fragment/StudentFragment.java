package com.example.studentmanager.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.studentmanager.R;
import com.example.studentmanager.activity.StudentActivity;
import com.example.studentmanager.activity.StudentListActivity;
import com.example.studentmanager.model.Student;
import com.example.studentmanager.model.StudentLab;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class StudentFragment extends Fragment {

    private  static String STUDENT_UUID="StudentUUID";

    private final  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    private EditText mTxtName;

    private EditText mTxtDni;
    private EditText mTxtUniversity;
    private EditText mTxtCareer;
    private EditText mTxtPeriod;
    private EditText mTxtGpa;
    private RadioButton mRadMale;
    private RadioButton mRadFemale;
    private ImageView mImageView;

    private DatePickerDialog mDialog;


    private Button mAddOrUpdateStudent;
    private Button mBtnBirthDate;

    private Student mStudent;

    private  static final String DIALOG_DATE ="DialogDate";
    private static final int REQUEST_DATE=0;

    private static  final String STUDENT_CREATED = "StudentCreated";

    Date mDate;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);




    }



    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        setMenuVisibility(false);





        View v = inflater.inflate(R.layout.fragment_student,container,false);

        mRadFemale = (RadioButton) v.findViewById(R.id.radio_button_female);
        mRadMale= (RadioButton)v.findViewById(R.id.radio_button_male);


        mTxtName = (EditText)v.findViewById(R.id.edit_text_name);
        mTxtDni= (EditText)v.findViewById(R.id.edit_text_dni);
        mTxtCareer = (EditText) v.findViewById(R.id.edit_text_career);
        mTxtGpa =(EditText) v.findViewById(R.id.edit_text_gpa);
        mTxtUniversity= (EditText) v.findViewById(R.id.edit_text_university);
        mTxtPeriod = (EditText) v.findViewById(R.id.edit_text_period);

        mRadMale.setSelected(true);


        mBtnBirthDate = v.findViewById(R.id.button_birth_date);
        mBtnBirthDate.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                 Calendar cldr = Calendar.getInstance();
                final int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);




                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        mDate = new GregorianCalendar(year,month,day+1).getTime();




                        String date =  sdf.format(mDate);   // Preparing the date to get inserted


                        mBtnBirthDate.setText(date);


                    }



                };

                mDialog = new DatePickerDialog(getContext(), listener, year, month, day);

                mDialog.setTitle(R.string.date_birth_dialog);






                mDialog.show();





            }



    });


        mAddOrUpdateStudent = v.findViewById(R.id.button_add_student);


        mAddOrUpdateStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StudentLab studentLab = StudentLab.get(getContext());

                String name = mTxtName.getText().toString();
                String dni = mTxtDni.getText().toString();
                boolean sex = mRadMale.isSelected();
                String university = mTxtUniversity.getText().toString();
                String career = mTxtCareer.getText().toString();
                int period = Integer.parseInt(mTxtPeriod.getText().toString());
                float gpa = Float.parseFloat(mTxtGpa.getText().toString());

                  if(mDate==null){
                      mDate=mStudent.getBirthDate();
                  }


                 String  id = getActivity().getIntent().getStringExtra(STUDENT_UUID);

                 Student student;
                 if(id!=null){

                     UUID uuid = UUID.fromString(id);
                    student = new Student(uuid,name,mDate,dni,sex,null,university,career,period,gpa);
                    studentLab.updateStudent(student);


                }   else {

                     student = new Student(name,mDate,dni,sex,null,university,career,period,gpa);
                     studentLab.addStudent(student);

                }





                Intent intent = new Intent(getContext(), StudentListActivity.class);



                startActivity(intent);








            }
        });



         String  id = getActivity().getIntent().getStringExtra(STUDENT_UUID);
        if(id!=null){

            mStudent = StudentLab.get(getContext()).getStudentById(UUID.fromString(id));

            mTxtName.setText(mStudent.getName());
            mTxtDni.setText(mStudent.getDni());
            mBtnBirthDate.setText(sdf.format(mStudent.getBirthDate()));
            mTxtGpa.setText(String.valueOf(mStudent.getGpa()));
            mTxtPeriod.setText(String.valueOf(mStudent.getPeriod()));
            mTxtCareer.setText(mStudent.getCareer());
            mTxtUniversity.setText(mStudent.getUniversity());


            mRadMale.setSelected(mStudent.isSex());
            mRadFemale.setSelected(mStudent.isSex());

            setMenuVisibility(true);



            Drawable icon;


            icon = getResources().getDrawable(R.drawable.edit_icon);


            mAddOrUpdateStudent.setCompoundDrawables(icon,null,null,null);
            mAddOrUpdateStudent.setText(R.string.student_edit);





        }



        return  v;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_student,menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.delete_student:

                StudentLab.get(getContext()).deleteStudent(mStudent);

                Intent intent = new Intent(getContext(),StudentListActivity.class);

                startActivity(intent);


                break;

        }



        return super.onOptionsItemSelected(item);
    }

    public static  Intent newIntent(Context context, UUID uuid){

        Intent intent = new Intent(context, StudentActivity.class);

        intent.putExtra(STUDENT_UUID,uuid.toString());



        return intent;

    }



}
