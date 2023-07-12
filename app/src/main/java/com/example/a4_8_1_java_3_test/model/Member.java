package com.example.a4_8_1_java_3_test.model;

import android.os.Parcelable;

import java.io.Serializable;

public class Member implements Serializable {
    private String ism,familya;

    public Member(String ism, String familya){
        this.ism=ism;
        this.familya=familya;
    }

    @Override
    public String toString() {
        return "Member{" +
                "ism='" + ism + '\'' +
                ", familya='" + familya + '\'' +
                '}';
    }
}
