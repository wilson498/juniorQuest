package org.example.leetcode.wordle.response;

import lombok.Data;
import org.example.leetcode.wordle.enumdata.GameStatus;

@Data
public class WordleGameResponse {
    private String result;
    private GameStatus gameStatus;
    private int count;


    public WordleGameResponse(String result, GameStatus gameStatus, int count) {
        this.result = result;
        this.gameStatus = gameStatus;
        this.count = count;
    }
}
