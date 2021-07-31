package com.example.loancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MonthTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_table);

        TableLayout stk = (TableLayout) findViewById(R.id.table_main1);
        TableRow tbrows0 = new TableRow(this);
        TextView rv01 = new TextView(this);
        rv01.setText("Month   ");
        tbrows0.addView(rv01);
        TextView rv02 = new TextView(this);
        rv02.setText("Interest Paid(RM)");
        tbrows0.addView(rv02);
        stk.addView(tbrows0);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserEntry", Context.MODE_PRIVATE);
        String LoanAmount2 = sp.getString("loan amount","");
        String InterestRate2 = sp.getString("interest rate","");
        String LoanPeriod2 = sp.getString("loan period","");
        String monthPay2 = sp.getString("monthly pay", "");

        DecimalFormat df2 = new DecimalFormat("0.00");
        double tLoanAmount1 = Double.parseDouble(LoanAmount2);
        double tInterestRate1 = Double.parseDouble(InterestRate2);
        int tLoanPeriod1 = Integer.parseInt(LoanPeriod2);
        double monthlyInterestRate = tInterestRate1 / 12;
        double mp2 = Double.parseDouble(monthPay2);
        for (int t = 1; t <= tLoanPeriod1; t++) {
            double interestPaid1 = tLoanAmount1 * (monthlyInterestRate / 100);
            double principalPaid1 = mp2 - interestPaid1;
            tLoanAmount1 -= principalPaid1;
            
            String sInterest1 = df2.format(interestPaid1);
            
            
            TableRow tbrows = new TableRow(this);
            TextView r1v = new TextView(this);
            r1v.setText(" "+ t +" ");
            tbrows.addView(r1v);
            TextView r2v = new TextView(this);
            r2v.setText(sInterest1);
            tbrows.addView(r2v);
            stk.addView(tbrows);

        }
    }
}