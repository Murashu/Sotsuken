package com.example.a171y063.myapplication;

import java.io.Serializable;

public class Quiz2 implements Serializable {
    int q_num; // 問題番号
    int image; // 画像ID
    String[] choices = new String[4]; // 選択肢
    String answer_index; // 正解の選択肢
    String Commentary;                      //  解説

    public static Quiz2[] quizzes = new Quiz2[9]; // クイズの配列

    private Quiz2(int q_num, int image, String[] choices, String answer_index, String Commentary) {
        this.q_num = q_num;
        this.image = image;
        this.choices = choices;
        this.answer_index = answer_index;
        this.Commentary = Commentary;
    }

    // 問題の登録(ここでは1問のみ)
    public static void init() {
        quizzes[0] = new Quiz2(0, R.drawable.fuji, new String[]{"富士山", "2", "3", "4"}, "富士山", "　解説");
        quizzes[1] = new Quiz2(1, R.drawable.borabora, new String[]{"1","2","ボラボラ島","4"},"ボラボラ島", "　解説");
        quizzes[2] = new Quiz2(2, R.drawable.niagala, new String[]{"1","2", "3", "ナイアガラの滝"},"ナイアガラの滝", "　解説");
        quizzes[3] = new Quiz2(3, R.drawable.uyuni, new String[]{"1", "ウユニ塩湖", "3", "4"}, "ウユニ塩湖", "　解説");
        quizzes[4] = new Quiz2(4, R.drawable.noish, new String[]{"1", "2","3","ノイシュバンシュタイン城"},"ノイシュバンシュタイン城", "解説");
        quizzes[5] = new Quiz2(5,R.drawable.mendenhole, new String[]{"", "メンデンホール氷河", "", ""},"メンデンホール氷河", "　解説");
        quizzes[6] = new Quiz2(6,R.drawable.roubai, new String[]{"老梅石槽", "", "", ""},"老梅石槽", "　解説");
        quizzes[7] = new Quiz2(7,R.drawable.grandcanyon, new String[]{"", "グランドキャニオン", "", ""}, "グランドキャニオン", "　解説");
        quizzes[8] = new Quiz2(8,R.drawable.marble, new String[]{"マーブルカテドラル", "", "", ""},"マーブルカテドラル","　チリ南部のパタゴニア地方にある世界で最も美しいと称される洞窟");
        /*quizzes[9] = new Quiz2(9,R.drawable., new String[]{},,);
        quizzes[10] = new Quiz2(10,R.drawable., new String[]{},,);
        quizzes[11] = new Quiz2(11,R.drawable., new String[]{},,);
        quizzes[12] = new Quiz2(12,R.drawable., new String[]{},,);
        quizzes[13] = new Quiz2(13,R.drawable., new String[]{},,);
        quizzes[14] = new Quiz2(14,R.drawable., new String[]{},,);
        quizzes[15] = new Quiz2(15,R.drawable., new String[]{},,);
        quizzes[16] = new Quiz2(16,R.drawable., new String[]{},,);
        quizzes[17] = new Quiz2(17,R.drawable., new String[]{},,);
        quizzes[18] = new Quiz2(18,R.drawable., new String[]{},,);
        quizzes[19] = new Quiz2(19,R.drawable., new String[]{},,);
        quizzes[20] = new Quiz2(20,R.drawable., new String[]{},,);
        quizzes[21] = new Quiz2(21,R.drawable., new String[]{},,);
        quizzes[22] = new Quiz2(22,R.drawable., new String[]{},,);
        quizzes[23] = new Quiz2(23,R.drawable., new String[]{},,);
        quizzes[24] = new Quiz2(24,R.drawable., new String[]{},,);*/

        //      quizzes[] = new Quiz2(,R.drawable., new String[]{},,);
    }

    // 問題を取得する
    public static Quiz2 getQuiz(int num) {
        if (num >= quizzes.length) {
            return null;
        }
        return quizzes[num];
    }
}