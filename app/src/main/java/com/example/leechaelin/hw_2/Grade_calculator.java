package com.example.leechaelin.hw_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Grade_calculator extends AppCompatActivity {
    EditText e1,e2,e3;
    TextView v1,v2;
    Button b1,b2;
    ImageView i1;
    int sum=0;
    double average=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_calculator);
        setTitle("학점 계산기 ");
        init();
    }
    void init() {
        e1 = (EditText) findViewById(R.id.editText1);
        e2 = (EditText) findViewById(R.id.editText2);
        e3 = (EditText) findViewById(R.id.editText3);
        v1 = (TextView) findViewById(R.id.textVeiw6);
        v2 = (TextView) findViewById(R.id.textView8);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        i1 = (ImageView) findViewById(R.id.iv_grade);

    }

    public void onMyClick(View v){
        if(v.getId()==R.id.button1){
            cal();
            changeimage(average);

        }
        else if(v.getId()==R.id.button2){
            reset();
            //changeimage(average);
        }
    }

    void cal(){
        String s1= e1.getText().toString();
        String s2 = e2.getText().toString();
        String s3 = e3.getText().toString();
        if(s1.equals("")|| s2.equals("")||s3.equals("")){
            sum = 0;
            average = 0;
        }
        else{
            sum = Integer.parseInt(s1)+Integer.parseInt(s2)+Integer.parseInt(s3);
            average = sum/3;
        }
        v1.setText(String.format(String.valueOf(sum))+"점");
        v2.setText(String.format(String.valueOf(average))+"점");

    }
    void reset(){
        e1.setText("");
        e2.setText("");
        e3.setText("");
        v1.setText("0점");
        v2.setText("0점 ");
        i1.setVisibility(View.GONE);
        Toast.makeText(getApplicationContext(),"초기화 되었습니다.",Toast.LENGTH_SHORT).show();

    }

    void changeimage(double average){
        i1.setVisibility(View.VISIBLE);

        if(average>=90)
            i1.setImageResource(R.drawable.a);
        else if(average>=80)
            i1.setImageResource(R.drawable.b);
        else if(average>=70)
            i1.setImageResource(R.drawable.c);
        else if(average>=60)
            i1.setImageResource(R.drawable.d);
        else
            i1.setImageResource(R.drawable.f);


    }

}

