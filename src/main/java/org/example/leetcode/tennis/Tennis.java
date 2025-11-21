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
        GameStatus gameStatus = getGameStatus();
        return switch (gameStatus) {
            case DEUCE -> "deuce";
            case GAME_OVER -> getAdvantageTeam() + " win";
            case ADVANTAGE -> getAdvantageTeam() + " adv";
            case CONDUCT -> getNormal();
        };
    }

    private String getNormal() {
        String aScoreString = getScoreStringText(teamAScoreCount);
        String bScoreString = getScoreStringText(teamBScoreCount);
        return aScoreString + "-" + (isSameScore() ? "all" : bScoreString);
    }


    private GameStatus getGameStatus() {
        if (isDeuce()) {
            return GameStatus.DEUCE;
        }
        if (isGameOver()) {
            return GameStatus.GAME_OVER;
        }
        if (isAdvantageGame()) {
            return GameStatus.ADVANTAGE;
        }
        return GameStatus.CONDUCT;

    }

    private boolean isGamePoint() {
        return teamAScoreCount > 3 || teamBScoreCount > 3;
    }

    private boolean isSameScore() {
        return teamAScoreCount == teamBScoreCount;
    }

    private boolean isDeuce() {
        return teamAScoreCount >= 3 && isSameScore();
    }

    private boolean isGameOver() {
        return isGamePoint() && Math.abs(teamAScoreCount - teamBScoreCount) > 1;
    }

    private boolean isAdvantageGame() {
        return teamAScoreCount >= 3 && teamBScoreCount >= 3 && !isSameScore();
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
        GAME_OVER,
        ADVANTAGE,
        CONDUCT
    }
}
