package org.example.leetcode.tennis;

import java.util.List;

public class Tennis {

    public final List<String> scoreList = List.of(
            "love",
            "fifteen",
            "thirty",
            "forty"
    );

    private int teamAScoreCount = 0;
    private int teamBScoreCount = 0;

    public void teamAScore() {
        teamAScoreCount++;
    }

    public void teamBScore() {
        teamBScoreCount++;
    }

    public String getCurrentScore() {
        StringBuilder result = new StringBuilder();

        String aScoreString = getScoreStringText(teamAScoreCount);
        String bScoreString = getScoreStringText(teamBScoreCount);

        boolean gamePoint = teamAScoreCount > 3 || teamBScoreCount > 3;
        boolean deuce = teamAScoreCount >= 3 && teamAScoreCount == teamBScoreCount;
        if (teamAScoreCount == teamBScoreCount && !deuce) {
            bScoreString = "all";
        }
        if (Math.abs(teamAScoreCount - teamBScoreCount) > 1 && gamePoint) {

            result.append(teamAScoreCount > teamBScoreCount ? "a" : "b").append(" win");

        } else {
            if (!deuce) {
                if (teamAScoreCount >= 3 && teamBScoreCount >= 3) {
                    result.append(teamAScoreCount > teamBScoreCount ? "a" : "b").append(" adv");
                } else {
                    result.append(aScoreString);
                    result.append("-");
                    result.append(bScoreString);
                }
            } else {
                result.append("deuce");
            }
        }
        return result.toString();
    }

    public String getScoreStringText(int count) {
        if (count > 3) {
            return scoreList.get(3);
        }
        return scoreList.get(count);
    }
}
