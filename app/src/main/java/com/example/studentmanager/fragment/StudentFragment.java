package com.example.studentmanager.fragment;

import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.studentmanager.R;

public class StudentFragment extends Fragment {

    private EditText mTxtName;
    private EditText mTxtBornDate;
    private EditText mTxtDni;
    private EditText mTxtUniversity;
    private EditText mTxtCareer;
    private EditText mTxtPeriod;
    private EditText mTxtGpa;
    private RadioButton mRadMale;
    private RadioButton mRadFemale;
    private ImageView mImageView;




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_student,container,false);
        mRadMale= v.findViewById(R.id.radio_button_male);
        mRadMale.setSelected(true);

        mTxtBornDate = v.findViewById(R.id.text_born_date);
        mTxtBornDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
