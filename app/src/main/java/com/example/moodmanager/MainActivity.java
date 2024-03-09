package com.example.moodmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnGenerate;
    TextView tv_answer, tvMainAnswer;
    int answerInt, genAnswerInt;
    LottieAnimationView lotty_sun, lotty_one, lotty_two;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lotty_sun = findViewById(R.id.lottie_sun);
        lotty_one = findViewById(R.id.lottie_one);
        lotty_two = findViewById(R.id.lottie_two);
        tv_answer = findViewById(R.id.tv_answer);
        tvMainAnswer = findViewById(R.id.tv_main_answer);
        btnGenerate = findViewById(R.id.btn_generate);
        lotty_sun.setAnimation(R.raw.good);
        lotty_one.setAnimation(R.raw.sp);
        lotty_two.setAnimation(R.raw.leaf);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V){
                Random random = new Random();
                genAnswerInt = random.nextInt(100);
                answerInt = genAnswerInt;
                if((answerInt != 0) && (answerInt > 0)){
                    tv_answer.setText(String.valueOf(answerInt) + "%");
                    printAnswer();
                    btnGenerate.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public void printAnswer() {
        if(answerInt >= 1 && answerInt <= 40) {
            tvMainAnswer.setText("Not bad!");
            lotty_two.setVisibility(View.VISIBLE);
        } else if(answerInt > 40 && answerInt <= 80) {
            tvMainAnswer.setText("EXCELLENT!");
            lotty_sun.setVisibility(View.VISIBLE);
        } else{
            tvMainAnswer.setText("SUPER!");
            lotty_one.setVisibility(View.VISIBLE);
        }
    }
}
