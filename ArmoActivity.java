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


public class ArmoActivity extends AppCompatActivity {
    
   
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armo);

        addTable();
        
        
        
    }
    
    public void addTable(){
        TableLayout stk = (TableLayout) findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(this);
        TextView tv01 = new TextView(this);
        tv01.setText("                                 ");
        tbrow0.addView(tv01);
        TextView tv0 = new TextView(this);
        tv0.setText("# ");
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setText("Principle(RM) ");
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText("Monthly payment(RM) ");
        tbrow0.addView(tv2);
        TextView tv3 = new TextView(this);
        tv3.setText("Interest paid(RM) ");
        tbrow0.addView(tv3);
        TextView tv4 = new TextView(this);
        tv4.setText("Principal paid(RM) ");
        tbrow0.addView(tv4);
        //add to table layout
        stk.addView(tbrow0);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("UserEntry", Context.MODE_PRIVATE);
        String yLoanAmount = sp.getString("loan amount","");
        String yInterestRate = sp.getString("interest rate","");
        String yLoanPeriod = sp.getString("loan period","");
        String monthPay = sp.getString("monthly pay", "");
        String totalPay = sp.getString("total pay", " ");


        DecimalFormat df2 = new DecimalFormat("0.00");

        double mp = Double.parseDouble(monthPay);
        double tLoanAmount = Double.parseDouble(yLoanAmount);
        double tInterestRate = Double.parseDouble(yInterestRate);
        int tLoanPeriod = Integer.parseInt(yLoanPeriod);
        double monthlyInterestRate = tInterestRate / 12;
        
       

        for (int g = 1; g <= tLoanPeriod; g++) {
            double interestPaid  =tLoanAmount * (monthlyInterestRate / 100);
            double principalPaid = mp - interestPaid;
            tLoanAmount -= principalPaid;
            
            String sPrincipal = df2.format(tLoanAmount);
            String sInterest = df2.format(interestPaid);
           String sPrincipalPaid = df2.format(principalPaid);
           String mp2 = df2.format(mp);
           

            TableRow tbrow = new TableRow(this);
            TextView t0v = new TextView(this);
            t0v.setText("                                 ");
            tbrow.addView(t0v);
            TextView t1v = new TextView(this);
            t1v.setText(" " + g + " ");
            tbrow.addView(t1v);
            TextView t2v = new TextView(this);
             t2v.setText(sPrincipal);
            tbrow.addView(t2v);
            TextView t3v = new TextView(this);
            t3v.setText(mp2);
            tbrow.addView(t3v);
            TextView t4v = new TextView(this);
            t4v.setText(sInterest);
            tbrow.addView(t4v);
            TextView t5v = new TextView(this);
            t5v.setText(sPrincipalPaid);
           tbrow.addView(t5v);
            stk.addView(tbrow);
            
            
            
        }
    }
    
   
    }
