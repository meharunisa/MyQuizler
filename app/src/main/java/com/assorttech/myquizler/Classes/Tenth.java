package com.assorttech.myquizler.Classes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.assorttech.myquizler.Adapter.MyCustomAdapter;
import com.assorttech.myquizler.NinthSubjects.NinthChemistry;
import com.assorttech.myquizler.NinthSubjects.NinthPhysics;
import com.assorttech.myquizler.R;
import com.assorttech.myquizler.TenthComplete.TenthSubjects.TenthPhysics;

public class Tenth extends AppCompatActivity {

    ListView mListView;
    String subjectList[] = {"Physics", "Chemistry", "Computer", "Biology", "English"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth);
        mListView = findViewById(R.id.list);

        MyCustomAdapter adapter=new MyCustomAdapter(this,subjectList);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    startActivity(new Intent(Tenth.this, TenthPhysics.class));
                }
                else if (position==1){

                    startActivity(new Intent(Tenth.this, NinthChemistry.class));
                }
            }
        });
    }
}
