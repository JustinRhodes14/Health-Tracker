package com.example.wrkout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;
import android.os.Bundle;

import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public Button bInit;
    public EditText exName;
    public EditText exType;
    public EditText intens;
    public EditText reps;
    public personInfo person = new personInfo("Justin Rhodes",19,148,72.5);

    private TextWatcher txtWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String inputtedexer = exName.getText().toString().trim();
            String inputtedextp = exType.getText().toString().trim();
            String inputtedintens = intens.getText().toString().trim();
            String inputtedrep = reps.getText().toString().trim();
            boolean enable = inputtedexer.length() != 0 && inputtedextp.length() != 0 && inputtedintens.length() != 0 && inputtedrep.length() != 0;

            bInit.setEnabled(enable);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exName = findViewById(R.id.edit1);
        exType = findViewById(R.id.edit2);
        intens = findViewById(R.id.edit3);
        reps = findViewById(R.id.edit4);
        bInit = findViewById(R.id.button2);

        bInit.setEnabled(false);

        setupViews();


    }
    public int computeWorkout(String work) {
        if (work.equals("Chest".toLowerCase())) {
            return 1;
        } else if (work.equals("Shoulders".toLowerCase())) {
            return 2;
        } else if (work.equals("Biceps".toLowerCase())) {
            return 3;
        } else if (work.equals("Legs".toLowerCase())) {
            return 4;
        } else if (work.equals("Abs".toLowerCase())) {
            return 5;
        } else if (work.equals("Neck".toLowerCase())) {
            return 6;
        } else if (work.equals("Back".toLowerCase())) {
            return 7;
        } else  {
            return 8;
        }
    }
    private void setupViews() {

        exName.addTextChangedListener(txtWatcher);
        exType.addTextChangedListener(txtWatcher);
        intens.addTextChangedListener(txtWatcher);
        reps.addTextChangedListener(txtWatcher);

        bInit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String inputtedex = exName.getText().toString().trim();
                String inputtedintens = intens.getText().toString().trim();
               String inputtedreps = reps.getText().toString().trim();
               String inputtedworkTp = exType.getText().toString().trim();
                person.addExcercise(inputtedex,Integer.parseInt(inputtedintens), computeWorkout(inputtedworkTp), Integer.parseInt(inputtedreps));
                person.updateReps(Integer.parseInt(inputtedreps));
                exName.setText("");
                exType.setText("");
                intens.setText("");
                reps.setText("");
                bInit.setEnabled(false);
                Toast.makeText(MainActivity.this, "Added " + person.getExercise(0).getName() +  "!", Toast.LENGTH_LONG).show();
            }
        });

    }

}
