package com.example.studentmanager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.studentmanager.R;
import com.example.studentmanager.activity.StudentActivity;
import com.example.studentmanager.model.Student;
import com.example.studentmanager.model.StudentLab;

import java.util.List;

public class StudentListFragment extends Fragment {


    private  RecyclerView mRecyclerView;
    private StudentAdapter mStudentAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         View v = inflater.inflate(R.layout.fragment_student_list,container,false);

        mRecyclerView =(RecyclerView) v.findViewById(R.id.student_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

         return v;


    }

    private  class StudentHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView mNameTextView;
        private TextView mDniTextView;
        private Student mStudent;


        public StudentHolder(LayoutInflater inflater, ViewGroup parent){
            super(inflater.inflate(R.layout.list_item_student,parent,false));

            mNameTextView = itemView.findViewById(R.id.student_name);
            mDniTextView = itemView.findViewById(R.id.student_dni);
            itemView.setOnClickListener(this);

        }


        public void onBind (Student s){
            mStudent =s;

            mNameTextView.setText(s.getName());
            mDniTextView.setText(s.getDni());


        }

        @Override
        public void onClick(View v) {

            Intent intent = StudentFragment.newIntent(getContext(),mStudent.getId());

            startActivity(intent);


        }
    }


    private class  StudentAdapter extends  RecyclerView.Adapter<StudentHolder>{


        private List<Student> mStudents;

        public  StudentAdapter (List<Student> students){
            mStudents = students;

        }


        @NonNull
        @Override
        public StudentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
           LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new StudentHolder(layoutInflater,viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentHolder studentHolder, int i) {
            Student student = mStudents.get(i);
            studentHolder.onBind(student);
        }

        @Override
        public int getItemCount() {
            return mStudents.size();
        }





    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_student_list,menu);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.new_student:
                Intent intent = new Intent(getContext(), StudentActivity.class);
                startActivity(intent);




            default:
                return super.onOptionsItemSelected(item);

        }






    }




    private void updateUI(){

        StudentLab studentLab = StudentLab.get(getActivity());

        List<Student> students = studentLab.getStudentList();

        mStudentAdapter = new StudentAdapter(students);

        mRecyclerView.setAdapter(mStudentAdapter);



    }






}




