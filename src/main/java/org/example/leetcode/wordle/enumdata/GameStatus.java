package org.example.leetcode.wordle.enumdata;


public enum GameStatus {
    WARNING(0, "錯誤"),
    WIN(1, "您贏了"),
    Fail(2, "您失敗了"),
    OVERED(3,"已結束" );;
    private final int code;
    private final String desc;

    GameStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
