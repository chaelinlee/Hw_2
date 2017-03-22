package com.example.leechaelin.hw_2;

import android.os.Build;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.TimePicker;

public class Reservation extends AppCompatActivity {
    int chap = 0;
    Switch s;
    Button b1,b2;
    Chronometer measure;
    DatePicker dp;
    TimePicker tp;
    EditText e1,e2,e3;
    TextView t1,t2,t3,t4,t5,res;
    LinearLayout l1,l2;
    GridLayout g1,g2;
    TableLayout tl1;
    FrameLayout f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        setTitle("레스토랑 예약하기 ");
        init();

    }

    void init(){
        s=(Switch)findViewById(R.id.started);
        measure=(Chronometer)findViewById(R.id.chronometer);
        b1 = (Button)findViewById(R.id.prev);
        b2 = (Button)findViewById(R.id.next);
        dp = (DatePicker)findViewById(R.id.datepicker);
        tp = (TimePicker)findViewById(R.id.timepicker);

        e1 = (EditText)findViewById(R.id.adult);
        e2 = (EditText)findViewById(R.id.teen);
        e3 = (EditText)findViewById(R.id.young);

        t1 = (TextView)findViewById(R.id.date);
        t2 = (TextView)findViewById(R.id.time);
        t3 = (TextView)findViewById(R.id.adult_num);
        t4 = (TextView)findViewById(R.id.teen_num);
        t5 = (TextView)findViewById(R.id.child_num);
        res = (TextView)findViewById(R.id.textview);

        f=(FrameLayout)findViewById(R.id.whole);
        l1 = (LinearLayout)findViewById(R.id.first);
        l2 = (LinearLayout)findViewById(R.id.second);
        g1 = (GridLayout)findViewById(R.id.third);
        g2 = (GridLayout)findViewById(R.id.buttons);
        tl1 = (TableLayout)findViewById(R.id.last);

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(s.isChecked()==true){
                    f.setVisibility(View.VISIBLE);
                    g2.setVisibility(View.VISIBLE);
                    res.setVisibility(View.VISIBLE);
                    measure.setVisibility(View.VISIBLE);
                    l1.setVisibility(View.VISIBLE);
                    tl1.setVisibility(View.INVISIBLE);

                    measure.setBase(SystemClock.elapsedRealtime());
                    measure.start();
                    b1.setEnabled(false);
                    b2.setEnabled(true);
                    chap = 0;
                }
                else{
                    f.setVisibility(View.INVISIBLE);
                    g2.setVisibility(View.INVISIBLE);
                    res.setVisibility(View.INVISIBLE);
                    measure.setVisibility(View.INVISIBLE);
                    measure.stop();
                    measure.setBase(SystemClock.elapsedRealtime());
                }
            }
        });

    }

    public void OnMyClick(View v){
        if(v.getId()==R.id.prev){
            if(chap>0)
                chap--;
        }
             pageChange(chap);

        if(v.getId()==R.id.next){
            if(chap<4)
                chap ++;
        }
            pageChange(chap);

    }

    void pageChange(int chap){
        if(chap==0){
            l1.setVisibility(View.VISIBLE);
            l2.setVisibility(View.INVISIBLE);
            g1.setVisibility(View.INVISIBLE);
            tl1.setVisibility(View.INVISIBLE);
            b1.setEnabled(false);
        }
        else if(chap==1){
            l1.setVisibility(View.INVISIBLE);
            l2.setVisibility(View.VISIBLE);
            g1.setVisibility(View.INVISIBLE);
            tl1.setVisibility(View.INVISIBLE);
            b1.setEnabled(true);
        }
        else if(chap==2){
            l1.setVisibility(View.INVISIBLE);
            l2.setVisibility(View.INVISIBLE);
            g1.setVisibility(View.VISIBLE);
            tl1.setVisibility(View.INVISIBLE);
            b2.setEnabled(true);
        }
        else if(chap==3){
            l1.setVisibility(View.INVISIBLE);
            l2.setVisibility(View.INVISIBLE);
            g1.setVisibility(View.INVISIBLE);
            tl1.setVisibility(View.VISIBLE);
            b2.setEnabled(false);
            result();
        }
    }


    void result(){
        int year = dp.getYear();
        int month = dp.getMonth();
        int day = dp.getDayOfMonth();
        int hour = tp.getHour();
        int minute = tp.getMinute();

        t1.setText(String.format(String.valueOf(year))+"년"+String.format(String.valueOf(month)+"월"+String.format(String.valueOf(day)+"일")));
        t2.setText(String.format(String.valueOf(hour))+"시"+String.format(String.valueOf(minute))+"분");

        int adult = Integer.parseInt(e1.getText().toString());
        int teenager = Integer.parseInt(e2.getText().toString());
        int children = Integer.parseInt(e3.getText().toString());

        t3.setText(String.format(String.valueOf(adult)+"명"));
        t4.setText(String.format(String.valueOf(teenager)+"명"));
        t5.setText(String.format(String.valueOf(children)+"명"));

    }


}
