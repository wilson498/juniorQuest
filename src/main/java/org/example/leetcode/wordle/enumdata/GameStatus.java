package org.example.leetcode.wordle.enumdata;


public enum GameStatus {
    WARG(0, "錯誤"),
    WIN(1, "您贏了"),
    Fail(2, "您失敗了");;
    private final int code;
    private final String desc;

    GameStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
