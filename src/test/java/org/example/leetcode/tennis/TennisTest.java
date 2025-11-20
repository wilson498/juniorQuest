package org.example.leetcode.tennis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TennisTest {


    private Tennis tennis;


    private void givenTeamScore(int aScoreCount, int bScoreCount) {
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
        givenTeamScore(0, 0);
        Assertions.assertEquals("love-all", tennis.getCurrentScore());
    }

    @Test
    void zero_fifteen() {
        givenTeamScore(0, 1);
        Assertions.assertEquals("love-fifteen", tennis.getCurrentScore());
    }

    @Test
    void zero_thirty() {
        givenTeamScore(0, 2);
        Assertions.assertEquals("love-thirty", tennis.getCurrentScore());
    }

    @Test
    void zero_forty() {
        givenTeamScore(0, 3);
        Assertions.assertEquals("love-forty", tennis.getCurrentScore());
    }

    @Test
    void fifteen_zero() {
        givenTeamScore(1, 0);
        Assertions.assertEquals("fifteen-love", tennis.getCurrentScore());
    }

    @Test
    void fifteen_fifteen() {
        givenTeamScore(1, 1);
        Assertions.assertEquals("fifteen-all", tennis.getCurrentScore());
    }

    @Test
    void fifteen_thirty() {
        givenTeamScore(1, 2);
        Assertions.assertEquals("fifteen-thirty", tennis.getCurrentScore());
    }

    @Test
    void fifteen_forty() {
        givenTeamScore(1, 3);
        Assertions.assertEquals("fifteen-forty", tennis.getCurrentScore());
    }

    @Test
    void thirty_zero() {
        givenTeamScore(2, 0);
        Assertions.assertEquals("thirty-love", tennis.getCurrentScore());
    }

    @Test
    void thirty_fifteen() {
        givenTeamScore(2, 1);
        Assertions.assertEquals("thirty-fifteen", tennis.getCurrentScore());
    }

    @Test
    void thirty_thirty() {
        givenTeamScore(2, 2);
        Assertions.assertEquals("thirty-all", tennis.getCurrentScore());
    }

    @Test
    void thirty_forty() {
        givenTeamScore(2, 3);
        Assertions.assertEquals("thirty-forty", tennis.getCurrentScore());
    }
    @Test
    void forty_zero() {
        givenTeamScore(3, 0);
        Assertions.assertEquals("forty-love", tennis.getCurrentScore());
    }


    @Test
    void forty_fifteen() {
        givenTeamScore(3, 1);
        Assertions.assertEquals("forty-fifteen", tennis.getCurrentScore());
    }


    @Test
    void forty_thirty() {
        givenTeamScore(3, 2);
        Assertions.assertEquals("forty-thirty", tennis.getCurrentScore());
    }

    @Test
    void forty_forty() {
        givenTeamScore(3, 3);
        Assertions.assertEquals("deuce", tennis.getCurrentScore());
    }

    @Test
    void a_win() {
        givenTeamScore(4, 2);
        Assertions.assertEquals("a win", tennis.getCurrentScore());
    }

    @Test
    void b_win(){
        givenTeamScore(2, 4);
        Assertions.assertEquals("b win", tennis.getCurrentScore());
    }

    @Test
    void a_advantage() {
        givenTeamScore(4, 3);
        Assertions.assertEquals("a adv", tennis.getCurrentScore());
    }

    @Test
    void a_advantage_before_win() {
        givenTeamScore(5, 3);
        Assertions.assertEquals("a win", tennis.getCurrentScore());
    }

    @Test
    void a_advantage_before_deuce() {
        givenTeamScore(4, 4);
        Assertions.assertEquals("deuce", tennis.getCurrentScore());
    }

    @Test
    void a_advantage_before_deuce_advantage() {
        givenTeamScore(5, 4);
        Assertions.assertEquals("a adv", tennis.getCurrentScore());
    }

    @Test
    void b_advantage() {
        givenTeamScore(3, 4);
        Assertions.assertEquals("b adv", tennis.getCurrentScore());
    }


    @Test
    void b_advantage_before_win() {
        givenTeamScore(3, 5);
        Assertions.assertEquals("b win", tennis.getCurrentScore());
    }

    @Test
    void b_advantage_before_deuce() {
        givenTeamScore(4, 4);
        Assertions.assertEquals("deuce", tennis.getCurrentScore());
    }

    @Test
    void b_advantage_before_deuce_advantage() {
        givenTeamScore(4, 5);
        Assertions.assertEquals("b adv", tennis.getCurrentScore());
    }

}