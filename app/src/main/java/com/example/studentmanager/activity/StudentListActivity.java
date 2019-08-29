package com.example.studentmanager.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.studentmanager.fragment.StudentListFragment;

public class StudentListActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new StudentListFragment();
    }



}
