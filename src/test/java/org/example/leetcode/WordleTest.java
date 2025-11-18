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
    input = "aggie"
    res = "G___G"
    status = FAIL
9. 超出次數限制再次輸入 ?
    input = "aggie"
    res = "G___G"
   status = OVERED
 */
@SpringBootTest
public class WordleTest {

    private Wordle createWordle(String answer) {

        return new Wordle(answer);
    }

    @Test
    public void input_same_ans() {
        Wordle wordle = createWordle("apple");
        WordleGameResponse response = wordle.game("apple");
        assertionsGameStatusAndTips(response, "GGGGG", GameStatus.WIN);
    }

    private void assertionsGameStatusAndTips(WordleGameResponse response, String verifyTips, GameStatus virifyGameStatus) {
        Assertions.assertEquals(verifyTips, response.getTips());
        Assertions.assertEquals(virifyGameStatus, response.getGameStatus());
    }

    @Test
    public void 輸入字母有正確且位置正確() {
        Wordle wordle = createWordle("apple");
        WordleGameResponse response = wordle.game("bspir");
        assertionsGameStatusAndTips(response, "__G__", GameStatus.WARNING);
    }

    @Test
    public void 輸入字母有正確但位置不正確() {
        Wordle wordle = createWordle("apple");
        WordleGameResponse response = wordle.game("blirw");
        assertionsGameStatusAndTips(response, "_Y___", GameStatus.WARNING);
    }

    @Test
    public void 輸入字母正確位置正確與位置不正確且都有重複字母_答案字母數量只有1個() {
        Wordle wordle = createWordle("apple");
        WordleGameResponse response = wordle.game("xllee");
        assertionsGameStatusAndTips(response, "_Y__G", GameStatus.WARNING);
    }

    @Test
    public void 輸入字母正確位置不正確且有重複字母_答案字母數量為多() {
        Wordle wordle = createWordle("apple");
        WordleGameResponse response = wordle.game("swrpp");
        assertionsGameStatusAndTips(response, "___YY", GameStatus.WARNING);
    }

    @Test
    public void 輸入字母無正確() {
        Wordle wordle = createWordle("apple");
        WordleGameResponse response = wordle.game("rrrrr");
        assertionsGameStatusAndTips(response, "_____", GameStatus.WARNING);
    }

    @Test
    public void 次數限制內猜對() {
        Wordle wordle = createWordle("apple");
        executionCount(wordle, "egpia", 5);
        WordleGameResponse response = wordle.game("apple");
        assertionsGameStatusAndTips(response, "GGGGG", GameStatus.WIN);
    }


    @Test
    public void 達次數限制依然猜錯() {
        Wordle wordle = createWordle("apple");
        executionCount(wordle, "aggie", 5);
        WordleGameResponse response = wordle.game("aggie");
        assertionsGameStatusAndTips(response, "G___G", GameStatus.FAIL);
    }

    @Test
    public void 超出次數限制再次輸入() {
        Wordle wordle = createWordle("apple");
        executionCount(wordle, "aggie", 6);
        WordleGameResponse response = wordle.game("aggie");
        assertionsGameStatusAndTips(response, "G___G", GameStatus.OVERED);

    }

    private void executionCount(Wordle wordle, String input, int count) {
        for (int i = 0; i < count; i++) {
            wordle.game(input);
        }
    }

}
