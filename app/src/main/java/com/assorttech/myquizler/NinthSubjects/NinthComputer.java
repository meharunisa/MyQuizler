package com.assorttech.myquizler.NinthSubjects;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.assorttech.myquizler.Adapter.MyCustomAdapter;
import com.assorttech.myquizler.NinthChemistryQuizType.NinthChemistryPastPapers;
import com.assorttech.myquizler.R;

public class NinthComputer extends AppCompatActivity {

    ListView mListView;
    String subjectList[] = {"Past Papers", "First half book", "Second Half book","Full book"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninth_computer);

        mListView = findViewById(R.id.list);

        MyCustomAdapter adapter=new MyCustomAdapter(this,subjectList);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    startActivity(new Intent(NinthComputer.this, NinthChemistryPastPapers.class));
                }
            }
        });
    }
}
