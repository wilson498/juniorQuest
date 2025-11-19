package org.example.leetcode.wordle;

/*

Wordle 猜字遊戲邏輯：遊戲有一個固定的秘密單字，玩家每次輸入一個猜測單字，例如 allee。 系統會依照每個字母與答案的對應關係，回傳結果玩家最多可猜 6 次；
如果6次內有猜中答案，則會告訴玩家「Win」，如果失敗則會告訴玩家「Fail」。
每次猜的時候會回傳提示，如下：

每個字母會有三種狀態：

G：字母正確，位置也正確
Y：字母存在於答案中，但位置錯誤
：字母不存在於答案中
處理順序如下：

先標出所有位置正確 (G) 的字母
再從剩下的字母中找出存在但位置錯誤 (Y) 的字母
每個字母只能被配對一次
答案：apple
猜測：allee
結果：G Y  _ _ G
 */

import org.example.leetcode.wordle.entity.LetterDataProcess;
import org.example.leetcode.wordle.enumdata.GameStatus;
import org.example.leetcode.wordle.enumdata.LetterStatus;
import org.example.leetcode.wordle.response.WordleGameResponse;

public class Wordle {
    public final static int MAX_COUNT = 6;

    private final String answer;
    private final LetterDataProcess letterDataProcess;
    private int currentCount;

    public Wordle(String answer) {
        this.answer = answer.toLowerCase();
        this.letterDataProcess = new LetterDataProcess(this.answer);
        currentCount = 0;
    }

    private void addCurrentCount() {
        currentCount++;
    }

    private GameStatus getGameStatus(String input) {
        if (currentCount > Wordle.MAX_COUNT) {
            return GameStatus.OVERED;
        } else if (answer.equals(input)) {
            currentCount = Wordle.MAX_COUNT;
            return GameStatus.WIN;
        } else if (currentCount == Wordle.MAX_COUNT) {
            return GameStatus.FAIL;
        } else {
            return GameStatus.WARNING;
        }
    }


    private char[] createGreenChars(String input) {
        char[] chars = new char[answer.length()];
        for (int index = 0; index < input.length(); index++) {
            chars[index] = '_';
            char ch = input.charAt(index);
            if (LetterStatus.CORRECT == letterDataProcess.checkLetterStatus(ch, index)) {
                chars[index] = 'G';
                letterDataProcess.removeLetterData(ch);
            }
        }
        return chars;
    }

    private char[] checkFinalYellowChars(String input, char[] chars) {
        for (int index = 0; index < chars.length; index++) {
            if (chars[index] == 'G') {
                continue;
            }
            char ch = input.charAt(index);
            if (LetterStatus.EXIST == letterDataProcess.checkLetterStatus(ch, index)) {
                chars[index] = 'Y';
                letterDataProcess.removeLetterData(ch);
            }
        }
        return chars;
    }

    private char[] createTips(String input) {
        letterDataProcess.resetMap();

        char[] chars = createGreenChars(input);
        return checkFinalYellowChars(input, chars);
    }

    public WordleGameResponse game(String input) {
        addCurrentCount();
        String guess = input.toLowerCase();
        return new WordleGameResponse(createTips(guess), getGameStatus(guess), currentCount);
    }
}
