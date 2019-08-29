package com.example.studentmanager.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.studentmanager.R;
import com.example.studentmanager.fragment.StudentFragment;

public class StudentActivity extends SingleFragmentActivity{


    @Override
    protected Fragment createFragment() {
        return new StudentFragment();
    }




}
