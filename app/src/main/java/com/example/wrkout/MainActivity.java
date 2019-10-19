package com.example.wrkout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personInfo person = new personInfo("John Snow", 19, 154.2,72.5);
        person.addExcercise("Push ups",3,3);
    }

}
