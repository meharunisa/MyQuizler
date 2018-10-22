package com.assorttech.myquizler.NinthPhysicsQuizType;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.assorttech.myquizler.Model.MultipleChoice;
import com.assorttech.myquizler.NinthSubjects.NinthPhysics;
import com.assorttech.myquizler.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NinthPastPapers extends AppCompatActivity {



    private DatabaseReference mDatabaseReference;
    private TextView mQuestionTextView, mScoreTextView;
    private Button btnOption1, btnOption2, btnOption3, btnOption4;
    int mQuestion, mOption1, mOption2, mOption3, mOption4, mAnswer;
    int mScore,i;

    final List<MultipleChoice> multipleQuestions = new ArrayList<>();


    // TODO: question bank

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninth_past_papers);

        mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        mScoreTextView=findViewById(R.id.score);

        if (savedInstanceState != null) {

            mScore = savedInstanceState.getInt("ScoreKey");
            i = savedInstanceState.getInt("IndexKey");

        } else {
            mScore = 0;
            i = 0;
        }

        mQuestionTextView = findViewById(R.id.qusetionView);
        btnOption1 = findViewById(R.id.button1);
        btnOption2 = findViewById(R.id.button2);
        btnOption3 = findViewById(R.id.button3);
        btnOption4 = findViewById(R.id.button4);


        mDatabaseReference.child("Classes").child("Ninth").child("Physics").child("Type").child("Past_paper");
        Query query = mDatabaseReference.orderByKey();
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Iterator<DataSnapshot> dataSnapshots = dataSnapshot.getChildren().iterator();

                while (dataSnapshots.hasNext()) {
                    DataSnapshot dataSnapshotChild = dataSnapshots.next();
                    MultipleChoice multipleChoice = dataSnapshotChild.getValue(MultipleChoice.class);
                    multipleQuestions.add(multipleChoice);
                }
                // Check your arraylist size and pass to list view like
                if(multipleQuestions.size()>0)
                {

                    for ( i=0 ;i< multipleQuestions.size();i++)
                    {
//
                       mQuestion=multipleQuestions.get(i).getQuestionID();
                       mOption1=multipleQuestions.get(i).getOption1();
                        mOption2=multipleQuestions.get(i).getOption2();
                        mOption3 =multipleQuestions.get(i).getOption3();
                        mOption4=multipleQuestions.get(i).getOption4();
                        mAnswer=multipleQuestions.get(i).getAnswer();


                        mQuestionTextView.setText(mQuestion);
                        btnOption1.setText(mOption1);
                        btnOption2.setText(mOption2);
                        btnOption3.setText(mOption3);
                        btnOption4.setText(mOption4);

                        mScoreTextView.setText("Score "+mScore+"/"+multipleQuestions.size());
//
        btnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mOption1 = multipleQuestions.get(i).getOption1();
                checkAnswer(mOption1);
                updateQuestion();
            }
        });
        btnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mOption2 = multipleQuestions.get(i).getOption2();
                checkAnswer(mOption2);
                updateQuestion();
            }
        });
        btnOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mOption3 = multipleQuestions.get(i).getOption3();
                checkAnswer(mOption3);
                updateQuestion();
            }
        });
        btnOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(mOption4);
                updateQuestion();
            }
        });

                    }

                }else
                {
                    Toast.makeText(NinthPastPapers.this, "data not entered", Toast.LENGTH_SHORT).show();
                    // Display dialog for there is no user available.
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//
//
    }


    private  void updateQuestion(){

        i=(i+1)%multipleQuestions.size();
        if (i==0){
            final AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("your score"+"  "+mScore+" / "+multipleQuestions.size());
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();

                }
            });

            alert.setNegativeButton("Restart Quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    mScore=0;
                    mScoreTextView.setText("Score "+mScore+"/"+multipleQuestions.size());
                    dialog.cancel();
                }
            });

            alert.show();
        }

        mQuestion = multipleQuestions.get(i).getQuestionID();
        mOption1 = multipleQuestions.get(i).getOption1();
        mOption2 = multipleQuestions.get(i).getOption2();
        mOption3 = multipleQuestions.get(i).getOption3();
        mOption4 = multipleQuestions.get(i).getOption4();

        mQuestionTextView.setText(mQuestion);
        btnOption1.setText(mOption1);
        btnOption2.setText(mOption2);
        btnOption3.setText(mOption3);
        btnOption4.setText(mOption4);

        mScoreTextView.setText("Score "+mScore+"/"+multipleQuestions.size());

    }
    public void checkAnswer(int userSelection) {
        int correctAnswer = multipleQuestions.get(i).getAnswer();
        if (userSelection == correctAnswer) {
            Log.d("Check","got it"+userSelection);

            Toast.makeText(NinthPastPapers.this, "You got it!", Toast.LENGTH_LONG).show();
            mScore=mScore+1;

        } else {

            Toast.makeText(NinthPastPapers.this, "Wrong!", Toast.LENGTH_LONG).show();
        }
    }
}
