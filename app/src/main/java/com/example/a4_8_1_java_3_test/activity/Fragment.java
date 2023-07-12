package com.example.a4_8_1_java_3_test.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.a4_8_1_java_3_test.R;
import com.example.a4_8_1_java_3_test.databinding.ActivityFragmentBinding;
import com.example.a4_8_1_java_3_test.fragment.FragmentFirst;
import com.example.a4_8_1_java_3_test.fragment.FragmentSecond;
import com.example.a4_8_1_java_3_test.model.Member;

public class Fragment extends AppCompatActivity implements FragmentFirst.FirstListner, FragmentSecond.SecondListner {
    ActivityFragmentBinding F_Binding;
    FragmentFirst fragmentFirst;
    FragmentSecond fragmentSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        F_Binding=ActivityFragmentBinding.inflate(getLayoutInflater());
        View view=F_Binding.getRoot();
        setContentView(view);
        initViews();
    }
    void initViews(){
        fragmentFirst = new FragmentFirst();
        fragmentSecond = new FragmentSecond();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.firstFragment,fragmentFirst)
                .replace(R.id.secondFragment,fragmentSecond)
                .commit();
    }

    @Override
    public void onFisrtSend(Member str) {
        fragmentSecond.updateSecondText(str);
    }

    @Override
    public void onSecondSend(Member str) {
        fragmentFirst.updateFirstText(str);
    }
}