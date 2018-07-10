package com.example.a171y063.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 171y063 on 2018/06/08.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( //  テーブル世界遺産
                "CREATE TABLE IF NOT EXISTS WorldHeritage(id int, Image_id String, answer1 string, answer2 String, answer3 String, answer4 String, Correct String);"
        );
        db.execSQL( //  テーブル絶景
                "CREATE TABLE IF NOT EXISTS SuperbView(id int, Image_id String, answer1 string, answer2 String, answer3 String, answer4 String, Correct String);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
