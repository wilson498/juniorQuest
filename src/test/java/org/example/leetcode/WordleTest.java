package org.example.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WordleTest {


    @Test
    public void winGameTest() {
        Wordle wordle = new Wordle("apple");
        String result = wordle.gameRefactor("apple");
        Assertions.assertEquals("Win", result);
    }

    @Test
    public void OneGameGameTest2() {
        Wordle wordle = new Wordle("apple");
        String result = wordle.gameRefactor("allee");
        Assertions.assertEquals("GY__G", result);
    }


    @Test
    public void TwoFailGameTest3() {
        Wordle wordle = new Wordle("apple");
        String result = wordle.gameRefactor("egpia");
        Assertions.assertEquals("Y_G_Y", result);
    }

    @Test
    public void FiveGameWinGameTest3() {
        Wordle wordle = new Wordle("apple");
        for(int i =0;i<5;i++) {
            String result = wordle.gameRefactor("egpia");
            Assertions.assertEquals("Y_G_Y", result);
        }
        String r = wordle.gameRefactor("apple");
        Assertions.assertEquals("Win", r);
    }

    @Test
    public void FailGameTest3() {
        Wordle wordle = new Wordle("apple");
        String result;
        for (int i = 0; i < 5; i++) {
            result = wordle.gameRefactor("aggie");
            Assertions.assertEquals("G___G", result);
        }
        result = wordle.gameRefactor("aggie");
        Assertions.assertEquals("Fail", result);

    }

}
