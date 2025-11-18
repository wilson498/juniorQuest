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
   status = WARNING
3. input = "blirw" 輸入字母有正確但位置不正確
   tips = "_Y___
   status = WARNING
4. input = "xllee" 輸入字母有正確但重複輸入_答案字母數量都為1
   res = "_Y__G"
   status = WARNING
5. input = "swrpp" 輸入字母有正確但重複輸入_答案字母數量為多
   res = "___YY"
   status = WARNING
6. input = "rrrrr 輸入字母無正確
   res = "_____"
   status = WARNING
7. 次數限制內猜對
    res="GGGGG"
    status = WIN
8. 達次數限制依然猜錯
   status = FAIL
9. 超出次數限制再次輸入 ?
   status = OVERED
 */
@SpringBootTest
public class WordleTest {

    private Wordle createWordle(String input) {
        
        return new Wordle(input);
    }

    @Test
    public void 輸入與答案相同() {
        Wordle wordle = createWordle("apple");
        WordleGameResponse response = wordle.game("apple");
        Assertions.assertEquals("GGGGG", response.getTips());
        Assertions.assertEquals(GameStatus.WIN, response.getGameStatus());
    }

    @Test
    public void 輸入字母有正確且位置正確() {
        Wordle wordle = createWordle("apple");
        WordleGameResponse response = wordle.game("bspir");
        Assertions.assertEquals("__G__", response.getTips());
        Assertions.assertEquals(GameStatus.WARNING, response.getGameStatus());
    }

    @Test
    public void 輸入字母有正確但位置不正確() {
        Wordle wordle = createWordle("apple");
        WordleGameResponse response = wordle.game("blirw");
        Assertions.assertEquals("_Y___", response.getTips());
        Assertions.assertEquals(GameStatus.WARNING, response.getGameStatus());
    }

    @Test
    public void 輸入字母有正確但重複輸入_答案字母數量都為1() {
        Wordle wordle = createWordle("apple");
        WordleGameResponse response = wordle.game("xllee");
        Assertions.assertEquals("_Y__G", response.getTips());
    }

    @Test
    public void 輸入字母有正確但重複輸入_答案字母數量為多() {
        Wordle wordle = createWordle("apple");
        WordleGameResponse response = wordle.game("blirw");
        String result = wordle.game("swrpp").getTips();
        Assertions.assertEquals("___YY", result);
    }

    @Test
    public void 輸入字母無正確() {
        Wordle wordle = createWordle("apple");
        WordleGameResponse response = wordle.game("blirw");
        String result = wordle.game("rrrrr").getTips();
        Assertions.assertEquals("_____", result);
    }

    @Test
    public void 次數限制內猜對() {
        Wordle wordle = createWordle("apple");
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
        Wordle wordle = createWordle("apple");
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
        Wordle wordle = createWordle("apple");
        String temp;
        for (int i = 0; i < 6; i++) {
            temp = wordle.game("aggie").getTips();
            Assertions.assertEquals("G___G", temp);
        }
        WordleGameResponse response = wordle.game("aggie");
        Assertions.assertEquals(7, response.getCount());
        GameStatus result = response.getGameStatus();
        Assertions.assertEquals(GameStatus.OVERED, result);

    }

}
