package com.assorttech.myquizler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.assorttech.myquizler.Classes.FirstYear;
import com.assorttech.myquizler.Classes.Ninth;
import com.assorttech.myquizler.Classes.SecondYear;
import com.assorttech.myquizler.Classes.Tenth;

public class MainActivity extends AppCompatActivity {

    Button mNinth, mTenth, mFirstyear, mSecondyear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNinth=findViewById(R.id.nineth);
        mTenth=findViewById(R.id.tenth);
        mFirstyear=findViewById(R.id.first_year);
        mSecondyear=findViewById(R.id.second_year);

        mNinth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Ninth.class));
            }
        });

        mTenth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Tenth.class));
            }
        });
        mFirstyear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FirstYear.class));
            }
        });
        mSecondyear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondYear.class));
            }
        });

    }
}
