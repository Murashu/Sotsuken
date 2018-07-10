package com.example.a171y063.myapplication;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CommentaryActivity extends Activity {

    private TextView Comment1, Comment2, Comment3, Comment4, Comment5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commentary);

        Comment1 = (TextView) findViewById(R.id.comment1);
        Comment2 = (TextView) findViewById(R.id.comment2);
        Comment3 = (TextView) findViewById(R.id.comment3);
        Comment4 = (TextView) findViewById(R.id.comment4);
        Comment5 = (TextView) findViewById(R.id.comment5);

        Comment1.setText(getIntent().getStringExtra("com1"));
        Comment2.setText(getIntent().getStringExtra("com2"));
        Comment3.setText(getIntent().getStringExtra("com3"));
        Comment4.setText(getIntent().getStringExtra("com4"));
        Comment5.setText(getIntent().getStringExtra("com5"));
    }

    public void onClick(View view){ //  result画面に戻るonClick
        finish();
    }
}
