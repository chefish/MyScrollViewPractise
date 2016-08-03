package com.fish.myscrollviewpractise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ScrollView ss;
    LinearLayout ll;
    LinearLayout ll1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ll = (LinearLayout) findViewById(R.id.linear);
        ll1 = (LinearLayout) findViewById(R.id.linear1);

        for (int i = 0; i < 100; i++) {
            TextView tv=new TextView(this);
            tv.setText("" + i);
            tv.setTextSize(20);
            ll.addView(tv);
        }
        for (int i = 0; i < 100; i++) {
            TextView tv=new TextView(this);
            tv.setText("" + i);
            tv.setTextSize(20);
            ll1.addView(tv);
        }

//
//        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int x = 10;
//                x++;
//            }
//        });


    }
}
