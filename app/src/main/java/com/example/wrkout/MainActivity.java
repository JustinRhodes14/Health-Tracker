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
    private Button bInit;
    private EditText exName;
    private EditText exType;
    private EditText intens;
    private EditText reps;


    private TextWatcher txtWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String inputtedexer = exName.getText().toString().trim();
            String inputtedexTp = exType.getText().toString().trim();
            String inputtedInten = intens.getText().toString().trim();
            String inputtedRep = reps.getText().toString().trim();
            boolean enable = inputtedexer.length() != 0 && inputtedexTp.length() != 0 && inputtedInten.length() != 0 && inputtedRep.length() != 0;

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
        exName = findViewById(R.id.exerName);
        exType = findViewById(R.id.exerType);
        intens = findViewById(R.id.intens);
        reps = findViewById(R.id.reps);
        bInit = findViewById(R.id.button2);

        bInit.setEnabled(false);


    }

    private void setupViews() {

        exName.addTextChangedListener(txtWatcher);
        exType.addTextChangedListener(txtWatcher);
        intens.addTextChangedListener(txtWatcher);
        reps.addTextChangedListener(txtWatcher);

        bInit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String inputteduserID = exName.getText().toString().trim();
                String inputtedpassID = exType.getText().toString().trim();
                String inputteduserID = intens.getText().toString().trim();
                String inputtedpassID = reps.getText().toString().trim();

                LoginManager loginManager = new LoginManager(inputteduserID, inputtedpassID, new LoginListener() {
                    @Override
                    public void onLoginSuccess(String name, String cardNum, ArrayList<Transaction> transactions) {

                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(LoginActivity.this, SummaryActivity.class);
                        intent.putExtra("customer", name);
                        intent.putExtra("lastFour", cardNum);
                        intent.putExtra("transactions", transactions);

                        startActivity(intent);

                    }

                    @Override
                    public void onLoginError(Exception exception) {

                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();

                    }
                });

                loginManager.execute();
            }
        });

    }

}
