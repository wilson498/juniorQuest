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

        GameStatus gameStatus = getGameStatus(deuce, gamePoint);
        switch (gameStatus) {
            case DEUCE -> result.append("deuce");
            case WIN -> result.append(getAdvantageTeam()).append(" win");
            case ADVANTAGE -> result.append(getAdvantageTeam()).append(" adv");
            case CONDUCT -> result.append(aScoreString)
                    .append("-")
                    .append(isSameScore ? "all" : bScoreString);

        }
        return result.toString();
    }

    private GameStatus getGameStatus(boolean deuce, boolean gamePoint) {
        if (deuce) {
            return GameStatus.DEUCE;
        } else if (Math.abs(teamAScoreCount - teamBScoreCount) > 1 && gamePoint) {
            return GameStatus.WIN;
        } else if (teamAScoreCount >= 3 && teamBScoreCount >= 3) {
            return GameStatus.ADVANTAGE;
        } else {
            return GameStatus.CONDUCT;
        }
    }


    private String getAdvantageTeam() {
        return teamAScoreCount > teamBScoreCount ? "a" : "b";
    }

    private String getScoreStringText(int count) {
        if (count > 3) {
            return scoreList.get(3);
        }
        return scoreList.get(count);
    }

    enum GameStatus {
        DEUCE,
        WIN,
        ADVANTAGE,
        CONDUCT
    }
}
