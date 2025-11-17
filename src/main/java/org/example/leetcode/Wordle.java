package org.example.leetcode;

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

@Slf4j
public class Wordle {
    private final String ans;
    private int MAX_COUNT = 6;

    public Wordle(String ans) {
        this.ans = ans;

    }


    private char checkChar(int index, char ch) {
        if (ans.charAt(index) == ch) {
            return 'G';
        } else {
            return ans.contains(String.valueOf(ch)) ? 'Y' : '_';
        }
    }

    public String gameRefactor(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            char c = checkChar(i, ch);
            if (c == 'Y') {
                for (int j = i - 1; j >= 0; j--) {
                    if (input.charAt(j) == ch) {
                        c = '_';
                        break;
                    }
                }
                for (int j = 0; j < input.length(); j++) {
                    if (input.charAt(j) == ch && ans.charAt(j) == input.charAt(j)) {
                        c = '_';
                        break;
                    }
                }
            }
            result.append(c);
        }
        return gameResult(result);
    }

    private String gameResult(StringBuilder result) {
        if (result.toString().equals("GGGGG")) {
            return "Win";
        } else {
            MAX_COUNT--;
            if (MAX_COUNT < 1) {
                return "Fail";
            }
        }
        return result.toString();
    }


    public String game(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) == input.charAt(i)) {
                result.append("G");
                for (int j = i - 1; j >= 0; j--) {
                    if (input.charAt(j) == input.charAt(i) && ans.charAt(j) != input.charAt(j)) {
                        result.setCharAt(j, '_');
                        break;
                    }
                }
            } else {
                boolean flag = true;
                for (int j = 0; j < input.length(); j++) {
                    if (i != j && ans.charAt(j) == input.charAt(i)) {
                        boolean b = true;
                        for (int k = i - 1; k >= 0; k--) {
                            if (input.charAt(i) == input.charAt(k)) {
                                b = false;
                                break;
                            }
                        }
                        if (b) {

                            result.append("Y");
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    result.append("_");
                }
            }


        }
        return gameResult(result);
    }


}
