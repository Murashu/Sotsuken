package com.example.a171y063.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import android.media.MediaPlayer;

public class MainActivity extends Activity {
    MediaPlayer mp, mpselect;
    public int first_num, first_num2;
    Random random = new Random();

    MainActivity(){
        first_num = random.nextInt(Quiz.quizzes.length);
        QuizActivity.quiz_num = first_num;
        first_num2 = random.nextInt(Quiz2.quizzes.length);
        Quiz2Activity.quiz_num = first_num2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(getApplicationContext(), R.raw.pastel);
        mpselect = MediaPlayer.create(getApplicationContext(), R.raw.select);

        mp.setLooping(true);    //  BGMをループ

        Quiz.init();
        Quiz2.init();
    }

    @Override
    protected void onResume(){
        super.onResume();
        mp.start(); // 再生

    }

    public void openQuiz(View view){
        mpselect.start();
        mp.stop();
        Intent intent = new Intent(getApplication(), QuizActivity.class);
        intent.putExtra("Quiz", Quiz.getQuiz(first_num));
        startActivity(intent);
    }
    public void openQuiz2(View view){
        mpselect.start();
        mp.stop();
        Intent intent = new Intent(getApplication(), Quiz2Activity.class);
        intent.putExtra("Quiz2", Quiz2.getQuiz((first_num2)));
        startActivity(intent);
    }
}
