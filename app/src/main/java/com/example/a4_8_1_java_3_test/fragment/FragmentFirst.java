package com.example.a4_8_1_java_3_test.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a4_8_1_java_3_test.R;
import com.example.a4_8_1_java_3_test.databinding.ActivityFragmentFirstBinding;
import com.example.a4_8_1_java_3_test.model.Member;

public class FragmentFirst extends Fragment {

    ActivityFragmentFirstBinding F_binding;

    public FirstListner listner;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_fragment_first,container,false);
        F_binding=ActivityFragmentFirstBinding.inflate(getLayoutInflater());
        view=F_binding.getRoot();


        initViews(view);
        return view;
    }
    void initViews(View view){

        F_binding.btFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Member member=new Member("Shaxzod", "Aliyev");



                listner.onFisrtSend(member);
            }
        });



//        F_binding.btFirst.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (F_binding.edFirst.getText().toString().isEmpty()){
//                    listner.onFisrtSend("Academy");
//                }else {
//                    String str_first=F_binding.edFirst.getText().toString();
//                    listner.onFisrtSend(str_first);
//                }
//
//            }
//        });
    }

    public interface FirstListner{
        void onFisrtSend(Member memberUp);
    }

    public void updateFirstText(Member memberIn){
        F_binding.tvFirst.setText(memberIn.toString());
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof FirstListner){
            listner=(FirstListner) context;
        }else {
            throw new RuntimeException(context.toString()+"Qandaydir Xato Yuz berdi");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        listner = null;
    }
}