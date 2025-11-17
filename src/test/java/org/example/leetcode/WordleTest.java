package org.example.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WordleTest {


    @Test
    public void 贏得遊戲＿回應Win() {
        Wordle wordle = new Wordle("apple");
        String result = wordle.game("apple").getResult();
        Assertions.assertEquals("Win", result);
    }

    @Test
    public void 輸入字串有重複字元_回傳相對應提示值() {
        Wordle wordle = new Wordle("apple");
        String result = wordle.game("allee").getResult();
        Assertions.assertEquals("GY__G", result);
    }


    @Test
    public void 輸入字串無重複字元_回傳相對應提示值() {
        Wordle wordle = new Wordle("apple");
        String result = wordle.game("aopde").getResult();
        Assertions.assertEquals("G_G_G", result);
    }

    @Test
    public void 遊戲限制次數內輸入正確＿贏得比賽_回應Win() {
        Wordle wordle = new Wordle("apple");
        for (int i = 0; i < 5; i++) {
            String result = wordle.game("egpia").getResult();
            Assertions.assertEquals("Y_G_Y", result);
        }
        String r = wordle.game("apple").getResult();
        Assertions.assertEquals("Win", r);
    }


    @Test
    public void 遊戲限制次數內_輸入最後一次還是錯誤_比賽失敗_回應Fail() {
        Wordle wordle = new Wordle("apple");
        String result;
        for (int i = 0; i < 5; i++) {
            result = wordle.game("aggie").getResult();
            Assertions.assertEquals("G___G", result);
        }
        result = wordle.game("aggie").getResult();
        Assertions.assertEquals("Fail", result);

    }

}
