package org.example.leetcode.tennis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TennisTest {


    private Tennis tennis;


    private void giveTeamScore(int aScoreCount, int bScoreCount) {
        for (int i = 0; i < aScoreCount; i++) {
            tennis.teamAScore();
        }
        for (int i = 0; i < bScoreCount; i++) {
            tennis.teamBScore();
        }
    }

    @BeforeEach
    void setUp() {
        tennis = new Tennis();
    }

    @Test
    void zero_zero() {
        Assertions.assertEquals("love-all", tennis.getCurrentScore());
    }

    @Test
    void fifteen_zero() {
        giveTeamScore(1, 0);
        Assertions.assertEquals("fifteen-love", tennis.getCurrentScore());
    }

    @Test
    void thirty_zero() {
        giveTeamScore(2, 0);
        Assertions.assertEquals("thirty-love", tennis.getCurrentScore());
    }

    @Test
    void zero_fifteen() {
        giveTeamScore(0, 1);
        Assertions.assertEquals("love-fifteen", tennis.getCurrentScore());
    }

    @Test
    void fifteen_fifteen() {
        giveTeamScore(1, 1);
        Assertions.assertEquals("fifteen-all", tennis.getCurrentScore());
    }

    @Test
    void forty_thirty() {
        giveTeamScore(3, 2);
        Assertions.assertEquals("forty-thirty", tennis.getCurrentScore());
    }

    @Test
    void forty_forty() {
        giveTeamScore(3, 3);
        Assertions.assertEquals("deuce", tennis.getCurrentScore());
    }

    @Test
    void a_advantage() {
        giveTeamScore(4, 3);
        Assertions.assertEquals("a adv", tennis.getCurrentScore());
    }

    @Test
    void a_win() {
        giveTeamScore(4, 2);
        Assertions.assertEquals("a win", tennis.getCurrentScore());
    }

    @Test
    void a_advantage_before_win() {
        giveTeamScore(5, 3);
        Assertions.assertEquals("a win", tennis.getCurrentScore());
    }

    @Test
    void b_advantage() {
        giveTeamScore(3, 4);
        Assertions.assertEquals("b adv", tennis.getCurrentScore());
    }

    @Test
    void b_advantage_before_win() {
        giveTeamScore(3, 5);
        Assertions.assertEquals("b win", tennis.getCurrentScore());
    }
}