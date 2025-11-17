package org.example.leetcode.wordle.response;

import lombok.Data;
import org.example.leetcode.wordle.enumdata.GameStatus;

@Data
public class WordleGameResponse {
    private String tips;
    private GameStatus gameStatus;
    private int count;


    public WordleGameResponse(String tips, GameStatus gameStatus, int count) {
        this.tips = tips;
        this.gameStatus = gameStatus;
        this.count = count;
    }


}
