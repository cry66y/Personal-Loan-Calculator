package com.example.loancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {
    
    private Button mArmoTableBtn, mMonthTableBtn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        
        Intent v = getIntent();
        String value1 = v.getStringExtra("EXTRA_KEY_1");
        String value2 = v.getStringExtra("EXTRA_KEY_2");
        
        
        
        
        TextView textView1 = (TextView) findViewById(R.id.eMonthPay);
        TextView textView2 = (TextView) findViewById(R.id.eTotalPay);
        textView1.setText(value1);
        textView2.setText(value2);
        
        mArmoTableBtn = (Button) findViewById(R.id.btnArmoTable);
        mMonthTableBtn = (Button) findViewById(R.id.btnMonthTable);
        
        mArmoTableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s = new Intent(MessageActivity.this, ArmoActivity.class);
                startActivity(s);
            }
            
        });
        
        mMonthTableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent y = new Intent(MessageActivity.this, MonthTableActivity.class);
                startActivity(y);
            }
        });
         
        
    }
}