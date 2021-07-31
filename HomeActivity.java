package com.example.loancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;


public class HomeActivity extends AppCompatActivity {
    
    
    
    
    private Button eCalBtn;
    EditText mLoanAmount, mInterestRate, mLoanPeriod;
    SharedPreferences sp;
    String la,ir, lp, mp1,tp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mLoanAmount = findViewById(R.id.eLoanAmount);
        mInterestRate = findViewById(R.id.eInterestRate);
        mLoanPeriod = findViewById(R.id.eLoanPeriod);
        eCalBtn = findViewById(R.id.btnCal);
        sp = getSharedPreferences("UserEntry", Context.MODE_PRIVATE);
        eCalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double LoanAmount = Integer.parseInt(mLoanAmount.getText().toString());
                double InterestRate = Integer.parseInt(mInterestRate.getText().toString());
                double LoanPeriod = Integer.parseInt(mLoanPeriod.getText().toString());
                double r = InterestRate/1200;
                double loan = Math.pow(1+r, LoanPeriod);
               
                
                double monthlyPayment = ((r+(r/(loan-1)))*LoanAmount);
                double totalPayment = monthlyPayment * LoanPeriod;
                DecimalFormat df = new DecimalFormat("####0.00");
                String mp =  df.format(monthlyPayment);
                String tp = df.format(totalPayment);
                
                la = mLoanAmount.getText().toString();
                ir = mInterestRate.getText().toString();
                lp = mLoanPeriod.getText().toString();
                mp1 = Double.toString(monthlyPayment);
                tp1 = Double.toString(totalPayment);
                
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("loan amount",la);
                editor.putString("interest rate",ir);
                editor.putString("loan period",lp);
                editor.putString("monthly pay", mp1);
                editor.putString("total pay", tp1);
                editor.commit();
                
                
                Intent i = new Intent(HomeActivity.this,MessageActivity.class);
                i.putExtra("EXTRA_KEY_1", mp);
                i.putExtra("EXTRA_KEY_2", tp);
                startActivity(i);
                
                
                
            }
        });
        
        
    }
}