package com.assorttech.myquizler.NinthSubjects;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.assorttech.myquizler.Adapter.MyCustomAdapter;
import com.assorttech.myquizler.Model.MultipleChoice;
import com.assorttech.myquizler.NinthPhysicsQuizType.NinthPastPapers;
import com.assorttech.myquizler.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NinthPhysics extends AppCompatActivity {

       ListView mListView;
    String subjectList[] = {"Past Papers", "First half book", "Second Half book","Full book"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninth_physics);


        mListView = findViewById(R.id.list);

        MyCustomAdapter adapter=new MyCustomAdapter(this,subjectList);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    startActivity(new Intent(NinthPhysics.this, NinthPastPapers.class));

                }
            }
        });
    }
}
