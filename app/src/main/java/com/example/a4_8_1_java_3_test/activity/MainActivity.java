package com.example.a4_8_1_java_3_test.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a4_8_1_java_3_test.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBd=ActivityMainBinding.inflate(getLayoutInflater());
        View view=mainBd.getRoot();
        setContentView(view);
        initViews();

    }
    void initViews(){
        mainBd.mainBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment();
            }
        });
    }

    void openFragment(){
        Intent intent=new Intent(this,Fragment.class);
        startActivity(intent);
    }
}