package com.example.a171y063.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result extends /*AppCompat*/Activity implements View.OnClickListener{

    public int correct;
    private TextView Result;

        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

            Intent intent = getIntent();
            correct = intent.getIntExtra("Result", 0);
            Result = (TextView)findViewById(R.id.Result);

            double percentage = (double)correct / 5 * 100;

            Result.setText("正答率 " + percentage + "%!");

            findViewById(R.id.backtitle).setOnClickListener(this);
            findViewById(R.id.buttonCommentary).setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.backtitle) {
            Intent intent = new Intent(this, MainActivity.class);   //  タイトル画面へ移動
            startActivity(intent);
        }else if(view.getId() == R.id.buttonCommentary){
            Intent intentCom = new Intent(this, CommentaryActivity.class);  //  解説画面表示
            intentCom.putExtra("com1", getIntent().getStringExtra("com1"));
            intentCom.putExtra("com2", getIntent().getStringExtra("com2"));
            intentCom.putExtra("com3", getIntent().getStringExtra("com3"));
            intentCom.putExtra("com4", getIntent().getStringExtra("com4"));
            intentCom.putExtra("com5", getIntent().getStringExtra("com5"));
            startActivity(intentCom);
        }
    }
}
