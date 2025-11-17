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

import lombok.extern.slf4j.Slf4j;
import org.example.leetcode.wordle.enumdata.GameStatus;
import org.example.leetcode.wordle.response.WordleGameResponse;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class Wordle {
    public final static int MAX_COUNT = 6;

    private final String ans;
    private int curCount;

    public Wordle(String ans) {
        this.ans = ans;
        curCount = 0;
    }

    private void addCount() {
        curCount++;
    }

    private GameStatus getGameStatus(String input) {
        if (curCount > Wordle.MAX_COUNT) {
            return GameStatus.OVERED;
        } else if (ans.equals(input)) {
            return GameStatus.WIN;
        } else if (curCount == Wordle.MAX_COUNT) {
            return GameStatus.Fail;
        } else {
            return GameStatus.WARING;
        }
    }

    private String createTips(String input) {
        char[] chars = input.toCharArray();
        Set<Character> gExist = new HashSet<>();
        Set<Character> yExist = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (ans.charAt(i) == chars[i]) {
                chars[i] = 'G';
                gExist.add(ans.charAt(i));
            } else if (ans.contains("" + chars[i])) {
                chars[i] = 'Y';
            } else {
                chars[i] = '_';
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'Y') {
                char ch = input.charAt(i);
                if (gExist.contains(ch) || yExist.contains(ch)) {
                    chars[i] = '_';
                } else {
                    yExist.add(ch);
                }
            }
        }

        return String.valueOf(chars);
    }

    public WordleGameResponse game(String input) {
        addCount();
        return new WordleGameResponse(
                createTips(input),
                getGameStatus(input),
                curCount
        );
    }
}
