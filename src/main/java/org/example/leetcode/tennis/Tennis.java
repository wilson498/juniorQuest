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
        GameStatus gameStatus = getGameStatus();
        switch (gameStatus) {
            case DEUCE -> result.append("deuce");
            case WIN -> result.append(getAdvantageTeam()).append(" win");
            case ADVANTAGE -> result.append(getAdvantageTeam()).append(" adv");
            case CONDUCT -> result.append(aScoreString)
                    .append("-")
                    .append(isSameScore() ? "all" : bScoreString);

        }

        return result.toString();
    }

    public Boolean isGamePoint() {
        return teamAScoreCount > 3 || teamBScoreCount > 3;
    }

    public Boolean isSameScore() {
        return teamAScoreCount == teamBScoreCount;
    }

    public Boolean isDeuce() {
        return teamAScoreCount >= 3 && isSameScore();
    }


    private GameStatus getGameStatus() {
        if (isDeuce()) {
            return GameStatus.DEUCE;
        } else if (isGamePoint() && Math.abs(teamAScoreCount - teamBScoreCount) > 1) {
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
