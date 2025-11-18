package org.example.leetcode;


import org.example.leetcode.wordle.Wordle;
import org.example.leetcode.wordle.enumdata.GameStatus;
import org.example.leetcode.wordle.response.WordleGameResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
ans = "apple"

1. input = ans 輸入與答案相同
   tips = "GGGGG"
   status = WIN
2. input = "bspir" 輸入字母有正確且位置正確
   tips = "__G__"
   status = WARING
3. input = "blirw" 輸入字母有正確但位置不正確
   tips = "_Y___
   status = WARING
5. input = "xllee" 輸入字母有正確但重複輸入，答案字母數量都為1
   res = "_Y__G"
   status = WARING
6. input = "swrpp" 輸入字母有正確但重複輸入，答案字母數量為2
   res = "___YY"
   status = WARING
7. 次數限制內猜對
    res="GGGGG"
    status = WIN
8. 達次數限制依然猜錯
   status = FAIL
9. 超出次數限制再次輸入
   status = OVERED
 */
@SpringBootTest
public class WordleTest {

    private Wordle createWordle() {
        return new Wordle("apple");
    }

    @Test
    public void 贏得遊戲＿回應Win() {
        Wordle wordle = createWordle();
        WordleGameResponse response = wordle.game("apple");
        Assertions.assertEquals("GGGGG", response.getTips());
        Assertions.assertEquals(GameStatus.WIN, response.getGameStatus());
    }

    @Test
    public void 輸入字母有正確且位置正確(){
        Wordle wordle = createWordle();
        WordleGameResponse response = wordle.game("bspir");
        Assertions.assertEquals("__G__", response.getTips());
        Assertions.assertEquals(GameStatus.WARING, response.getGameStatus());
    }

    @Test
    public void 輸入字幕有正確但位置不正確(){
        Wordle wordle = createWordle();
        WordleGameResponse response = wordle.game("blirw");
        Assertions.assertEquals("_Y___", response.getTips());
        Assertions.assertEquals(GameStatus.WARING, response.getGameStatus());
    }

    @Test
    public void 輸入字串有重複字元並且存在兩個相同的字元_回傳相對應提示值() {
        Wordle wordle = createWordle();
        WordleGameResponse response = wordle.game("blirw");
        String result = wordle.game("swrpp").getTips();
        Assertions.assertEquals("___YY", result);
    }

    @Test
    public void 輸入字串有重複字元_回傳相對應提示值() {
        Wordle wordle = createWordle();
        String result = wordle.game("xllee").getTips();
        Assertions.assertEquals("_Y__G", result);
    }


    @Test
    public void 輸入字串無重複字元_回傳相對應提示值() {
        Wordle wordle = createWordle();
        String result = wordle.game("aopde").getTips();
        Assertions.assertEquals("G_G_G", result);
    }


    @Test
    public void 次數限制內猜對() {
        Wordle wordle = createWordle();
        for (int i = 0; i < 5; i++) {
            String result = wordle.game("egpia").getTips();
            Assertions.assertEquals("Y_G_Y", result);
        }
        WordleGameResponse response = wordle.game("apple");
        GameStatus result = response.getGameStatus();
        Assertions.assertEquals(GameStatus.WIN, result);
    }


    @Test
    public void 達次數限制依然猜錯() {
        Wordle wordle = createWordle();
        String temp;
        for (int i = 0; i < 5; i++) {
            temp = wordle.game("aggie").getTips();
            Assertions.assertEquals("G___G", temp);
        }
        WordleGameResponse response = wordle.game("aggie");
        Assertions.assertEquals(6, response.getCount());
        GameStatus result = response.getGameStatus();
        Assertions.assertEquals(GameStatus.Fail, result);

    }

    @Test
    public void 超出次數限制再次輸入() {
        Wordle wordle = createWordle();
        String temp;
        for (int i = 0; i < 5; i++) {
            temp = wordle.game("aggie").getTips();
            Assertions.assertEquals("G___G", temp);
        }
        wordle.game("aggie");
        WordleGameResponse response = wordle.game("aggie");
        Assertions.assertEquals(7, response.getCount());
        GameStatus result = response.getGameStatus();
        Assertions.assertEquals(GameStatus.OVERED, result);

    }

}
