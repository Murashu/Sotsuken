package com.example.a171y063.myapplication;

import java.io.Serializable;

public class Quiz implements Serializable {
    int q_num;                              //  問題番号
    int image;                              //  画像ID
    String[] choices = new String[4];       //  選択肢
    String answer_index;                    //  正解の選択肢
    String Commentary;                      //  解説

    public static Quiz[] quizzes = new Quiz[23]; // クイズの配列

    private Quiz(int q_num, int image, String[] choices, String answer_index, String Commentary) {
        this.q_num = q_num;
        this.image = image;
        this.choices = choices;
        this.answer_index = answer_index;
        this.Commentary = Commentary;
    }

    /* ========= 問題の登録 ========= */
    public static void init() {
        quizzes[0] = new Quiz(0, R.drawable.himejicastle, new String[]{"松本城", "姫路城", "松山城", "熊本城"}, "姫路城", "　兵庫県の姫路市にある日本の城");
        quizzes[1] = new Quiz(1, R.drawable.familier, new String[]{"サグラダ・ファミリア","ピサの斜塔","タージマハル","ビッグ・ベン"},"サグラダ・ファミリア", "　スペインのバルセロナにあるカトリック教会のバシリカである。日本語では聖家族教会と呼ばれることも多い");
        quizzes[2] = new Quiz(2, R.drawable.liberty, new String[]{"母なる祖国像", "自由の女神像", "ローヂナ・マーチ像", "南シナ海観音菩薩"}, "自由の女神像", "　ローマ神話の自由の女神リベルタスをかたどった立像。");
        quizzes[3] = new Quiz(3, R.drawable.sanu, new String[]{"パリのセーヌ河岸","ドナウ河岸","ワット河岸","スキアヴォーニ河岸"},"パリのセーヌ河岸", "　フランスにあるユネスコ世界遺産のひとつ");
        quizzes[4] = new Quiz(4, R.drawable.mitchel, new String[]{"モン・サン=ミシェルとその湾", "ケベック歴史地区とその湾", "ホレズ修道院とその湾", "バンベルク市街とその湾"}, "モン・サン=ミシェルとその湾", "　フランス西海岸、サン・マロ湾上に浮かぶ小島、及びその上にそびえる修道院である");
        quizzes[5] = new Quiz(5, R.drawable.herakles, new String[]{"ロンドン塔","バベルの塔","ピサの斜塔","ヘラクレスの塔"},"ヘラクレスの塔", "　スペインにおける、ローマ建築の灯台");
        quizzes[6] = new Quiz(6,R.drawable.machu, new String[]{"知床", "オカバンゴ・デルタ", "マチュピチュ", "ドロミーティ"},"マチュピチュ", "　ペルーにあるインカの遺跡である");
        quizzes[7] = new Quiz(7,R.drawable.petra, new String[]{"ペトラ遺跡","アンコール遺跡","廃坑", "古代都市ウシュマル"},"ペトラ遺跡", "　ヨルダンにある遺跡。");
        quizzes[8] = new Quiz(8,R.drawable.taji, new String[]{"ヴェルサイユ宮殿", "クレムリン", "タージ・マハル", "フォンテーヌブロー宮殿"},"タージ・マハル", "　インド北部にある総大理石の墓廟");
        quizzes[9] = new Quiz(9,R.drawable.bigben, new String[]{"ベルンの時計塔", "天文時計台", "ビッグ・ベン", "大時計台グロ・オルロージュ"},"ビッグ・ベン", "　イギリスの首都ロンドンにあるウェストミンスター宮殿（英国国会議事堂）に付属する時計台の大時鐘");
        quizzes[10] = new Quiz(10,R.drawable.great, new String[]{"サンゴ集中地帯", "グレートバリアリーフ", "バリアグレートリーフ", "グレートリーフ"},"グレートバリアリーフ", "　オーストラリア北東岸に広がる世界最大のサンゴ礁地帯");
        quizzes[11] = new Quiz(11,R.drawable.yellowstone, new String[]{"プリトヴィッツェ湖群国立公園", "イエローストーン公園", "エバーグレーズ国立公園", "グエル公園"},"イエローストーン公園", "　アメリカ合衆国の国立公園");
        quizzes[12] = new Quiz(12,R.drawable.fukken, new String[]{"福建土楼", "福建士楼", "福建土桜", "福健土桜"},"福建土楼", "　中国福建省の独特の版築建築物");
        quizzes[13] = new Quiz(13,R.drawable.palmila, new String[]{"パルミラ遺産", "テオティワカン遺跡", "エフェソス遺跡", "アンコール遺跡"},"パルミラ遺産", "　シリア中央部のホムス県タドモルにあるローマ帝国支配時の都市遺跡");
        quizzes[14] = new Quiz(14,R.drawable.plaha, new String[]{"プラハ歴史地区", "古都ゲント", "歴史的城塞都市カルカソンヌ", "エディンバラ旧市街"},"プラハ歴史地区", "　チェコ、プラハにあるユネスコ世界遺産の日本における呼称");
        quizzes[15] = new Quiz(15,R.drawable.banri, new String[]{"万里の長城", "水原華城", "クロンボー城", "万里の城長"},"万里の長城", "　中華人民共和国に存在する城壁の遺跡");
        quizzes[16] = new Quiz(16,R.drawable.ogasawara, new String[]{"小笠原諸島", "屋久島", "奄美群島", "沖ノ島"},"小笠原諸島", "　東京都特別区の南南東約1,000kmの太平洋上にある30余の島々");
        quizzes[17] = new Quiz(17,R.drawable.londontower, new String[]{"ブラナの塔","ベレンの塔","ロンドン塔","トルンの斜塔"},"ロンドン塔", "　イギリスに築かれた中世の城塞");
        quizzes[18] = new Quiz(18,R.drawable.stonehenge, new String[]{"和順支石墓群","江華支石墓","ストーンヘンジ", "ストーンタウン"},"ストーンヘンジ", "　イギリス南部のストーンサークル");
        quizzes[19] = new Quiz(19,R.drawable.paltenon, new String[]{"パルテノン神殿", "エレクティオン", "アテナ・ニケ神殿", "ディオニソスの劇場"},"パルテノン神殿","　アテナイのアクロポリス上に建設された神殿。なお、選択肢の建物はすべてアクロポリス上に建設されている");
        quizzes[20] = new Quiz(20,R.drawable.opera, new String[]{"シドニー・オペラハウス", "ベルリン・ムゼウムスインゼル", "台湾・国立歴史博物館", "ローマ・浴場博物館"},"シドニー・オペラハウス","　オーストラリア・シドニーにある20世紀を代表する近代建築物であり、世界的に有名な歌劇場である");
        quizzes[21] = new Quiz(21,R.drawable.fuma, new String[]{"フマーユーン廟", "ブッダガヤの大菩提寺", "アーグラ城塞", "クトゥブ・ミナール "},"フマーユーン廟","インド共和国の首都デリーにある、ムガル帝国の第2代皇帝フマーユーンの墓廟");
        quizzes[22] = new Quiz(22,R.drawable.brenum, new String[]{"ブレナム宮殿", "ヴェルサイユ宮殿", "シェーンブルン宮殿", "エカテリーナ宮殿"},"ブレナム宮殿","　イギリスのオックスフォード郊外のウッドストックにある宮殿");
        /*quizzes[23] = new Quiz(23,R.drawable., new String[]{},,);
        quizzes[24] = new Quiz(24,R.drawable., new String[]{},,);*/
        //      quizzes[] = new Quiz(,R.drawable., new String[]{},,);
    }

    /* ========= 問題を取得する ========= */
    public static Quiz getQuiz(int num) {
        if (num >= quizzes.length) {
            return null;
        }
        return quizzes[num];
    }
}
