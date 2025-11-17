package org.example.leetcode.response;

import lombok.Data;
import org.example.leetcode.Wordle;
import org.example.leetcode.enumdata.GameStatus;

@Data
public class WordleGameResponse {
    private String result;
    private GameStatus gameStatus;
    private int count;



    public GameStatus checkGameStatus(String result) {
        if (count <= Wordle.MAX_COUNT) {
            if ("GGGGG".equals(result)) {
                return GameStatus.WIN;
            } else {
                return GameStatus.WARG;
            }
        }
        return GameStatus.Fail;
    }
}
