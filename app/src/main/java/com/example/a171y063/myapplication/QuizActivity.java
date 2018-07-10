package com.example.a171y063.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuizActivity extends Activity {

    public List<Integer> numberList = new ArrayList<>();
    private List<Integer> answerList = new ArrayList<>();
    public int Correct = 0;                     //  正解数
    public int count = 0;                       //  出題数
    private TextView Tv_num;
    private ImageView imageView;
    private Button[] buttons;
    private TextView result;
    private Button next;
    public static int quiz_num; //  MainActivityのコンストラクタで生成した一つの乱数（既出問題の番号）
    private String comment;
    private String[] SendComment;
    private int correctNum = 0;

    private Quiz quiz;

    private SoundPool soundPool;
    private int correct_se, ncorrect_se;  // 正解音声/不正解音声のID

    QuizActivity(){
        for (int i = 0; i < Quiz.quizzes.length; i++) {
            if(i == quiz_num){
                //  既出問題番号のためスルー
            }else {
                numberList.add(i);
            }
        }
        Collections.shuffle(numberList, new Random());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        SendComment = new String[5];
        /*========= 画面上のウィジェットを取得 ========= */
        Tv_num = (TextView) findViewById(R.id.q_string);
        imageView = (ImageView) findViewById(R.id.image_View);
        buttons = new Button[4];    //  ボタン
        buttons[0] = (Button) findViewById(R.id.btn1);
        buttons[1] = (Button) findViewById(R.id.btn2);
        buttons[2] = (Button) findViewById(R.id.btn3);
        buttons[3] = (Button) findViewById(R.id.btn4);

        result = (TextView)findViewById(R.id.result);

        // Android 5.0(Lolipop)より古いかどうかでSoundPoolの使い方は変わってくる
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            // Android 5.0(Lolipop)より古いとき
            //noinspection deprecation
            soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        } else {
            // Android 5.0(Lolipop)以降
            AudioAttributes attr = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(attr)
                    .setMaxStreams(2)
                    .build();
        }
        correct_se = soundPool.load(this, R.raw.correctse, 1); // 正解の効果音の識別IDを保存
        ncorrect_se = soundPool.load(this, R.raw.ncorrectse, 1); // 不正解の効果音の識別IDを保存

        /*========= データの取得 ========= */
        Intent intent = getIntent();
        next = (Button)findViewById(R.id.next);
        if (intent != null) {
            quiz = (Quiz) intent.getSerializableExtra("Quiz");
            show();
        }
    }
    /*========= 表示に反映 ========= */
    void show() {
        count++;
        if (quiz != null) {
            for(int i = 0; i < 4; i++){
                answerList.add(i);
            }
            Collections.shuffle(answerList, new Random());  //  選択肢をシャッフル

            Tv_num.setText("第" + count + "問");
            imageView.setImageResource(quiz.image);
            for (int i = 0; i < buttons.length; i++) {
                for(int k = 0; k < 4; k++) {
                    buttons[k].setEnabled(true);
                }
                int Substitution = answerList.get(i);
                buttons[i].setText(quiz.choices[Substitution]);
            }
            result.setText("");
            result.setBackgroundResource(R.drawable.clear);
            next.setVisibility(View.INVISIBLE);
            answerList.clear();     //  answerListの中身を削除
            if(count == 5 ){
                next.setText("結果画面へ");
            }
        }
    }
    public void answer(View view) {
        comment = Quiz.quizzes[numberList.get(correctNum)].Commentary;
        correctNum++;
        for (int i = 0; i < buttons.length; i++) {
            if (view.getId() == buttons[i].getId()) {
                if (buttons[i].getText() == quiz.answer_index) {
                    for(int k = 0; k < 4; k++) {
                        buttons[k].setEnabled(false);   //  ボタンを選択できなくする
                    }

                    result.setBackgroundResource(R.drawable.correct);
                    soundPool.play(correct_se, 1F, 1F, 0, 0, 1F);
                    Correct++;
                    next.setVisibility(View.VISIBLE);
                    if(count == 1){
                        comment = Quiz.quizzes[this.quiz_num].Commentary;
                        SendComment[0] = "第" + count + "問\n" + "あなたが選んだ答え：" + buttons[i].getText().toString() + "\n正解：" + quiz.answer_index + "\n" + comment;;
                    }else {
                        SendComment[count - 1] = "第" + count + "問\n" + "あなたが選んだ答え：" + buttons[i].getText().toString() + "\n正解：" + quiz.answer_index + "\n" + comment;    //  countが加算された後だから -1
                    }
                } else {
                    for(int k = 0; k < 4; k++) {
                        buttons[k].setEnabled(false);   //  ボタンを選択できなくする
                    }
                    result.setBackgroundResource(R.drawable.incorrect);
                    soundPool.play(ncorrect_se, 1F, 1F, 0, 0, 1F);
                    next.setVisibility(View.VISIBLE);
                    if(count == 1){
                        comment = Quiz.quizzes[this.quiz_num].Commentary;
                        SendComment[0] = "第" + count + "問\n" + "あなたが選んだ答え：" + buttons[i].getText().toString() + "\n正解：" + quiz.answer_index + "\n" + comment;;
                    }else {
                        SendComment[count - 1] = "第" + count + "問\n" + "あなたが選んだ答え：" + buttons[i].getText().toString() + "\n正解：" + quiz.answer_index + "\n" + comment;    //  countが加算された後だから -1
                    }
                }
            }
        }
    }
    /*========= 次の問題へ ========= */
    public void next(View view){
        quiz = Quiz.getQuiz(numberList.get(count));
        if (count < 5) {        //  全部出すなら if(quiz != null) 問題数を指定するなら if(count < num)
            show();
        } else {
            try {
                Thread.sleep(1000); //  待機処理（あとで消すかも）
                Intent intent = new Intent(getApplication(), Result.class); //  結果表示画面へ遷移
                intent.putExtra("Result", Correct);
                intent.putExtra("com1", SendComment[0]);
                intent.putExtra("com2", SendComment[1]);
                intent.putExtra("com3", SendComment[2]);
                intent.putExtra("com4", SendComment[3]);
                intent.putExtra("com5", SendComment[4]);
                startActivity(intent);
            }catch (InterruptedException e){

            }
        }
    }
}
