package com.example.test2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static com.example.test2.MainActivity.EXTRA_ID;

public class Q_A extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "q_a";
    //User user;
int count=0;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    Button Buttonipsilo;
    Button Buttonmetrio;
    Button buttonxamilo;
    Button buttonarista;
    Button Vhappy,Happy,NotHappy,Bad,An1,An2,An3,An4,An5;
    TextView Text;
    TextView time;
    TextView BranchId;
    TextView textview_id;
    public static final String KEY_ID="ID";
    public static final String KEY_ANSWER1="answers1";
    public static final String KEY_ANSWER2="answers2";
    public static final String KEY_ANSWER3="answers3";
    public static final String KEY_ANSWER4="answers4";
    public static final String KEY_QUESTION="QUESTION";

    private TextView questionTextView;
    private int currentQuestionIndex = 0;
    private int currentAnswerIndex = 0;
    private Question[] questionBank = new Question[]{
            new Question(R.string.question_declaration),
            new Question(R.string.question_declaration1),
            new Question(R.string.question_declaration2),

    };
    private Answer[] answerBank = new Answer[]{
            new Answer(R.string.answer_declaration),
            new Answer(R.string.answer_declaration1),
            new Answer(R.string.answer_declaration2),
            new Answer(R.string.answer_declaration3),
            new Answer(R.string.answer_declaration4),
            new Answer(R.string.answer_declaration5),
            new Answer(R.string.answer_declaration6),
            new Answer(R.string.answer_declaration7),

    };

private FirebaseFirestore db=FirebaseFirestore.getInstance();
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.q_a);
        buttonarista = findViewById(R.id.aristo);
        Buttonipsilo = findViewById(R.id.ipsilo);
        Buttonmetrio = findViewById(R.id.metrio);
        buttonxamilo = findViewById(R.id.xamhlo);

        questionTextView = findViewById(R.id.question);


        Intent intent = getIntent();
        String id = intent.getStringExtra(EXTRA_ID);
        textview_id = findViewById(R.id.text_view_id);

        textview_id.setText(id);
//        @SuppressLint("CutPasteId") TextView BranchId=findViewById(R.id.text_view_id);
//       @SuppressLint("CutPasteId") Button Vhappy=findViewById(R.id.aristo);
//       @SuppressLint("CutPasteId") Button Happy=findViewById(R.id.ipsilo);
//       @SuppressLint("CutPasteId") Button NotHappy=findViewById(R.id.metrio);
//       @SuppressLint("CutPasteId") Button Bad=findViewById(R.id.xamhlo);
//       @SuppressLint("CutPasteId") Button An1=findViewById(R.id.aristo);
//        @SuppressLint("CutPasteId") Button An2=findViewById(R.id.ipsilo);
//        @SuppressLint("CutPasteId") Button An3=findViewById(R.id.metrio);
//        @SuppressLint("CutPasteId") Button An4=findViewById(R.id.xamhlo);
//        @SuppressLint("CutPasteId") Button An5=findViewById(R.id.xamhlo);
//        @SuppressLint("CutPasteId") TextView Text=findViewById(R.id.question);
//        TextView time=findViewById(R.id.time);

        buttonarista.setOnClickListener(this);
        Buttonipsilo.setOnClickListener(this);
        Buttonmetrio.setOnClickListener(this);
        buttonxamilo.setOnClickListener(this);
//        rootNode=FirebaseDatabase.getInstance();
//        reference=rootNode.getReference("answers");


    }


    private void SendNetwokRequest(UserA userA) {
        Retrofit.Builder builder= new Retrofit.Builder()
                .baseUrl("https://go.mellon.com.gr/NBGStats/NBGStat.svc/SubmitAnswer/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit=builder.build();
        UserAns auser =retrofit.create(UserAns.class);
        Call<UserA> call =  auser.createAns(userA);

        call.enqueue(new Callback<UserA>() {
            @Override
            public void onResponse(Call<UserA> call, Response<UserA> response) {
                //assert response.body() != null;
                //Toast.makeText(Q_A.this, "Yeah! User-ID: " + response.body().getId(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Q_A.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<UserA> call, Throwable t) {
                //Toast.makeText(Q_A.this, "Something went wrong :(",Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void Post () {
        @SuppressLint("CutPasteId") TextView Text = findViewById(R.id.question);
        TextView time = findViewById(R.id.time);
        @SuppressLint("CutPasteId") Button An5 = findViewById(R.id.xamhlo);
        @SuppressLint("CutPasteId") TextView BranchId = findViewById(R.id.text_view_id);
        if (count > 1) {
            @SuppressLint("CutPasteId") Button An1 = findViewById(R.id.aristo);
            @SuppressLint("CutPasteId") Button An2 = findViewById(R.id.ipsilo);
            @SuppressLint("CutPasteId") Button An3 = findViewById(R.id.metrio);
            @SuppressLint("CutPasteId") Button An4 = findViewById(R.id.xamhlo);

            if (count == 0) {

                @SuppressLint("CutPasteId") Button Vhappy = findViewById(R.id.aristo);
                @SuppressLint("CutPasteId") Button Happy = findViewById(R.id.ipsilo);
                @SuppressLint("CutPasteId") Button NotHappy = findViewById(R.id.metrio);
                @SuppressLint("CutPasteId") Button Bad = findViewById(R.id.xamhlo);



            UserA userA = new UserA(BranchId.getText().toString(), Integer.parseInt(Vhappy.getText().toString()),
                    Integer.parseInt(Happy.getText().toString()), Integer.parseInt(NotHappy.getText().toString()),
                    Integer.parseInt(Bad.getText().toString()), Integer.parseInt(An1.getText().toString()),
                    Integer.parseInt(An2.getText().toString()), Integer.parseInt(An3.getText().toString()),
                    Integer.parseInt(An4.getText().toString()), Integer.parseInt(An5.getText().toString()),
                    Text.getText().toString(), Integer.parseInt(time.getText().toString())
            );
            SendNetwokRequest(userA);

        }

    }





            }







    @SuppressLint("ShowToast")
    public void onClick(View v) {
        String ID =textview_id.getText().toString().trim();
        String Q=questionTextView.getText().toString().trim();
        String A1=buttonarista.getText().toString().trim();
        String A2=Buttonipsilo.getText().toString().trim();
        String A3=Buttonmetrio.getText().toString().trim();
        String A4=buttonxamilo.getText().toString().trim();

            switch (v.getId()) {

                case R.id.aristo:
                    count =count+1;

                    currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;

                    Map<String, Object> data = new HashMap<>();
                    data.put(KEY_QUESTION, Q);
                    data.put(KEY_ID, ID);
                    data.put(KEY_ANSWER1, A1);
//                    data.put(KEY_ANSWER2, A2);
//                    data.put(KEY_ANSWER3, A3);
//                    data.put(KEY_ANSWER4, A4);


                    db.collection("QA").document("QA")
                            .set(data).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @SuppressLint("ShowToast")
                        @Override
                        public void onSuccess(Void aVoid) {
                            //Toast.makeText(Q_A.this, "Success", Toast.LENGTH_LONG).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG, "onFailure: " + e.toString());
                        }
                    });

                    updateQuestion();
                    updateAnswers();

                    if (count ==2) {
                        gobacktoMain();


                    }
                    // saveAnswer1();

                    break;
                case R.id.ipsilo:
                    count ++;
                    //go to next question
                    currentQuestionIndex = (currentQuestionIndex + 1) % questionBank.length;
                    Map<String, Object> data1 = new HashMap<>();
                    data1.put(KEY_QUESTION, Q);
                    data1.put(KEY_ID, ID);
                   // data1.put(KEY_ANSWER1, A1);
                    data1.put(KEY_ANSWER2, A2);
                   // data1.put(KEY_ANSWER3, A3);
                   // data1.put(KEY_ANSWER4, A4);

                    db.collection("QA").document("QA1")
                            .set(data1).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @SuppressLint("ShowToast")
                        @Override
                        public void onSuccess(Void aVoid) {
                            //Toast.makeText(Q_A.this, "Success", Toast.LENGTH_LONG).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG, "onFailure: " + e.toString());
                        }
                    });


                    updateQuestion();
                    updateAnswers();
                    if (count ==2) {
                        gobacktoMain();


                    }
                    // saveAnswer1();
                    break;
                case R.id.metrio:
                    if(count<2) {count ++;}

                    //go to next question
                    currentQuestionIndex = (currentQuestionIndex + 2) % questionBank.length;
                    Map<String, Object> data2 = new HashMap<>();
                    data2.put(KEY_QUESTION, Q);
                    data2.put(KEY_ID, ID);
                    //data2.put(KEY_ANSWER1, A1);
                   // data2.put(KEY_ANSWER2, A2);
                    data2.put(KEY_ANSWER3, A3);
                    //data2.put(KEY_ANSWER4, A4);

                    db.collection("QA").document("QA2")
                            .set(data2).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @SuppressLint("ShowToast")
                        @Override
                        public void onSuccess(Void aVoid) {
                            //Toast.makeText(Q_A.this, "Success", Toast.LENGTH_LONG).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG, "onFailure: " + e.toString());
                        }
                    });

                    updateQuestion();
                    updateAnswers();
                    if (count ==2) {
                        gobacktoMain();


                    }
                    //saveAnswer1();
                    break;
                case R.id.xamhlo:
                    count ++;
                    //go to next question
                    currentQuestionIndex = (currentQuestionIndex + 2) % questionBank.length;
                    Map<String, Object> data3 = new HashMap<>();
                    data3.put(KEY_QUESTION, Q);
                    data3.put(KEY_ID, ID);
                   // data3.put(KEY_ANSWER1, A1);
                   // data3.put(KEY_ANSWER2, A2);
                   // data3.put(KEY_ANSWER3, A3);
                    data3.put(KEY_ANSWER4, A4);

                    db.collection("QA").document("QA3")
                            .set(data3).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @SuppressLint("ShowToast")
                        @Override
                        public void onSuccess(Void aVoid) {
                            //Toast.makeText(Q_A.this, "Success", Toast.LENGTH_LONG).show();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG, "onFailure: " + e.toString());
                        }
                    });
                    if(count>2){updateQuestion();
                        updateAnswers();}

                    updateQuestion();
                    updateAnswers();
                    if (count ==2) {
                        gobacktoMain();


                    }

                        //saveAnswer1();
                        break;

                    }
            }
            public void gobacktoMain()

        {
            Post();
                for (int i=0; i < 3; i++)
                {

                    Toast.makeText(Q_A.this, "«Σας ευχαριστούμε πολύ για τον χρόνο σας»", Toast.LENGTH_LONG).show();
                }
            updateAnswersBack();
            updateQuestionBack();


//                        Intent intent = new Intent(this, MainActivity.class);
//                        startActivity(intent);



                count =count-2;
            }




    private void updateQuestion() {
        Log.d("Current", "onClick: " + currentQuestionIndex);
        questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
    }

    private void updateAnswers() {
        Log.d("Current", "onClick:" + currentAnswerIndex);

        buttonarista.setText(answerBank[currentAnswerIndex + 4].getAnswerId());
        Buttonipsilo.setText(answerBank[currentAnswerIndex + 5].getAnswerId());
        Buttonmetrio.setText(answerBank[currentAnswerIndex + 6].getAnswerId());
        buttonxamilo.setText(answerBank[currentAnswerIndex + 7].getAnswerId());

    }
    private void updateAnswersBack() {
        Log.d("Current", "onClick:" + currentAnswerIndex);

        buttonarista.setText(answerBank[currentAnswerIndex =0].getAnswerId());
        Buttonipsilo.setText(answerBank[currentAnswerIndex =1].getAnswerId());
        Buttonmetrio.setText(answerBank[currentAnswerIndex =2].getAnswerId());
        buttonxamilo.setText(answerBank[currentAnswerIndex =3].getAnswerId());
        //count=0;

    }
    private void updateQuestionBack() {
        Log.d("Current", "onClick: " + currentQuestionIndex);
        //
        questionTextView.setText(questionBank[currentQuestionIndex = 0].getAnswerResId());
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
//}
// if(currentQuestionIndex==1) {
// questionTextView.setText(questionBank[currentQuestionIndex=0].getAnswerResId());
// }
// count =0;

//    public void saveAnswer1 () {
//        buttonarista = findViewById(R.id.aristo);
//        Buttonipsilo = findViewById(R.id.ipsilo);
//        Buttonmetrio = findViewById(R.id.metrio);
//        buttonxamilo = findViewById(R.id.xamhlo);
//        if (buttonarista.length() != 0 && buttonxamilo.length() != 0 && Buttonipsilo.length() != 0 && Buttonmetrio.length() != 0) {
//            addAnswers(buttonarista.getText().toString(), buttonxamilo.getText().toString(), Buttonmetrio.getText().toString(), Buttonipsilo.getText().toString());
//        }
//    }
//
//    public void addAnswers(String buttonarista,String buttonxamilo,String Buttonmetrio,String Buttonipsilo) {
//        user = new User(buttonarista, buttonxamilo, Buttonipsilo, Buttonmetrio);
//        rootNode = FirebaseDatabase.getInstance();
//        reference = rootNode.getReference();
//        reference.child("answers").child(user.getButtonarista()).setValue(user);
//    }




//    public void saveAnswer1()
//    {
//        String answer1=buttonarista.getResources().getString(R.string.answer_declaration);
//        String answer2=Buttonipsilo.getResources().getString(R.string.answer_declaration1);
//        String answer3=Buttonmetrio.getResources().getString(R.string.answer_declaration2);
//        String answer4=buttonxamilo.getResources().getString(R.string.answer_declaration3);
//        userHelperanswer helperanswer=new userHelperanswer(answer1,answer2,answer3,answer4);
//        reference.child(answer1).setValue(helperanswer);
//        //Intent intent = new Intent(this, MainActivity.class);
//        //startActivity(intent);
//
//    }

//    private boolean isDoubleClick() {
//        if (!userHasClickedOnce) {
//            Toast.makeText(this, "Scanning", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                userHasClickedOnce = false;
//            }
//        }, 2000);
//
//        return true;
//    }
//}