package com.example.studentmanager.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TimePicker;

import com.example.studentmanager.R;
import com.example.studentmanager.model.Student;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class StudentFragment extends Fragment {

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


    private Button mAddStudenBtn;
    private Button mBtnBirthDate;

    private Student mStudent;

    private  static final String DIALOG_DATE ="DialogDate";
    private static final int REQUEST_DATE=0;
    Date mDate;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



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
                        mBtnBirthDate.setText(mDate.toString());


                    }



                };

                mDialog = new DatePickerDialog(getContext(), listener, year, month, day);

                mDialog.setTitle(R.string.date_birth_dialog);




                mDialog.show();





            }



    });


        mAddStudenBtn = v.findViewById(R.id.button_add_student);
        mAddStudenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = mTxtName.getText().toString();
                String dni = mTxtDni.getText().toString();
                boolean sex = mRadMale.isSelected();
                String university = mTxtUniversity.getText().toString();
                String career = mTxtCareer.getText().toString();
                int period = Integer.parseInt(mTxtPeriod.getText().toString());
                float gpa = Float.parseFloat(mTxtGpa.getText().toString());


            }
        });


        return  v;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_student,menu);

    }




}
