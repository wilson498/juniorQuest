package org.example.leetcode;


import org.example.leetcode.wordle.Wordle;
import org.example.leetcode.wordle.enumdata.GameStatus;
import org.example.leetcode.wordle.response.WordleGameResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WordleTest {


    @Test
    public void 贏得遊戲＿回應Win() {
        Wordle wordle = new Wordle("apple");
        WordleGameResponse response = wordle.game("apple");
        Assertions.assertEquals(GameStatus.WIN, response.getGameStatus());
    }
    @Test
    public void 輸入字串有重複字元_回傳相對應提示值2() {
        Wordle wordle = new Wordle("apple");
        String result = wordle.game("swrpp").getTips();
        Assertions.assertEquals("___YY", result);
    }

    @Test
    public void 輸入字串有重複字元_回傳相對應提示值() {
        Wordle wordle = new Wordle("apple");
        String result = wordle.game("allee").getTips();
        Assertions.assertEquals("GY__G", result);
    }


    @Test
    public void 輸入字串無重複字元_回傳相對應提示值() {
        Wordle wordle = new Wordle("apple");
        String result = wordle.game("aopde").getTips();
        Assertions.assertEquals("G_G_G", result);
    }


    @Test
    public void 遊戲限制次數內輸入正確＿贏得比賽_回應Win() {
        Wordle wordle = new Wordle("apple");
        for (int i = 0; i < 5; i++) {
            String result = wordle.game("egpia").getTips();
            Assertions.assertEquals("Y_G_Y", result);
        }
        WordleGameResponse response = wordle.game("apple");
        GameStatus result = response.getGameStatus();
        Assertions.assertEquals(GameStatus.WIN, result);
    }


    @Test
    public void 遊戲限制次數內_輸入最後一次還是錯誤_比賽失敗_回應Fail() {
        Wordle wordle = new Wordle("apple");
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
    public void 超出遊玩次數回傳OVERED() {
        Wordle wordle = new Wordle("apple");
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
