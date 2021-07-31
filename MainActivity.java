package com.example.loancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mPersonName;
    private EditText mStuID;
    private Button mBtnLogin;


    private String Username = "Steven";
    private String StudentId = "10101";

    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPersonName = findViewById(R.id.ePersonName);
        mStuID = findViewById(R.id.eStuID);
        mBtnLogin = findViewById(R.id.btnLogin);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = mPersonName.getText().toString();
                String inputStuId = mStuID.getText().toString();

                if(inputName.isEmpty()||inputStuId.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter all the info correctly!", Toast.LENGTH_SHORT).show();
                }else{
                    isValid = validate(inputName, inputStuId);

                    if(!isValid){
                        Toast.makeText(MainActivity.this, "Incorrect credential enter!", Toast.LENGTH_SHORT).show();
                    } else{
                        Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                        //connect to next page
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);


                    }
                }

            }
        });

    }

    private boolean validate(String name, String stuId){

        if(name.equals(Username)&&stuId.equals(StudentId)){
            return true;
        }
        
        return false;
    }
}
