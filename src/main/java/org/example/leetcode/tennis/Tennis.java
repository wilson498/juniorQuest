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
        boolean isSameScore = teamAScoreCount == teamBScoreCount;
        boolean deuce = teamAScoreCount >= 3 && isSameScore;

        if (deuce) {
            result.append("deuce");
        } else if (Math.abs(teamAScoreCount - teamBScoreCount) > 1 && gamePoint) {
            result
                    .append(getTeamLeader())
                    .append(" win");
        } else if (teamAScoreCount >= 3 && teamBScoreCount >= 3) {
            result
                    .append(getTeamLeader())
                    .append(" adv");
        } else {
            result.append(aScoreString)
                    .append("-")
                    .append(isSameScore ? "all" : bScoreString);
        }
        return result.toString();
    }

    private String getTeamLeader() {
        return teamAScoreCount > teamBScoreCount ? "a" : "b";
    }

    private String getScoreStringText(int count) {
        if (count > 3) {
            return scoreList.get(3);
        }
        return scoreList.get(count);
    }
}
