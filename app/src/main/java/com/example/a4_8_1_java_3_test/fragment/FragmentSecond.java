package com.example.a4_8_1_java_3_test.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.a4_8_1_java_3_test.R;
import com.example.a4_8_1_java_3_test.databinding.ActivityFragmentSecondBinding;
import com.example.a4_8_1_java_3_test.model.Member;

public class FragmentSecond extends Fragment {

    ActivityFragmentSecondBinding S_Binding;
    SecondListner listner;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_fragment_second,container,false);
        S_Binding=ActivityFragmentSecondBinding.inflate(getLayoutInflater());
        view=S_Binding.getRoot();
        initViews(view);
        return view;
    }
    void initViews(View view){

        S_Binding.btSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Member member=new Member("Fayzullo","Fozilov");

                listner.onSecondSend(member);
            }
        });


//        S_Binding.btSecond.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (S_Binding.edSecond.getText().toString().isEmpty()){
//                    listner.onSecondSend("PDP");
//                }else {
//                    String str_first=S_Binding.edSecond.getText().toString();
//                    listner.onSecondSend(str_first);
//                }
//            }
//        });
    }

    public interface SecondListner{
        void onSecondSend(Member member);
    }

   public void updateSecondText(Member memberSecond){
        S_Binding.tvSecond.setText(memberSecond.toString());
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof SecondListner){
            listner = (SecondListner) context;
        }else {
            throw  new RuntimeException(context.toString()+"Nimadir yuz berdi bu xato!");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listner = null;
    }
}