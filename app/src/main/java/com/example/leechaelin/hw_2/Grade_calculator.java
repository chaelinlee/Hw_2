package com.example.leechaelin.hw_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Grade_calculator extends AppCompatActivity {
    EditText e1,e2,e3;
    TextView v1,v2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_calculator);

    }
    void init(){
        e1 = (EditText)findViewById(R.id.editText1);
        e2 = (EditText)findViewById(R.id.editText2);
        e3 = (EditText)findViewById(R.id.editText3);
        v1 = (TextView)findViewById(R.id.textVeiw6);
        v2 = (TextView)findViewById(R.id.textView8);
        b1 = (Button)findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();

                if(s1.equals(""))
                    s1 ="0";
                if(s2.equals(""))
                    s2 ="0";
                if(s3.equals(""))
                    s3 ="0";

                double sum = Integer.parseInt(s1)+Integer.parseInt(s2)+Integer.parseInt(s3);
                double ans = sum/3;

                v1.setText(String.format(String.valueOf(sum))+"점");
                v2.setText(String.format(String.valueOf(ans))+"점");
            }
        });

    }
}
