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

    private void assertionCurrentScore(String expected) {
        Assertions.assertEquals(expected, tennis.getCurrentScore());
    }

    @Test
    void zero_zero() {
        assertionCurrentScore("love-all");
    }

    @Test
    void zero_fifteen() {
        givenTeamScore(0, 1);
        assertionCurrentScore("love-fifteen");
    }

    @Test
    void zero_thirty() {
        givenTeamScore(0, 2);
        assertionCurrentScore("love-thirty");
    }

    @Test
    void zero_forty() {
        givenTeamScore(0, 3);
        assertionCurrentScore("love-forty");
    }

    @Test
    void fifteen_zero() {
        givenTeamScore(1, 0);
        assertionCurrentScore("fifteen-love");
    }

    @Test
    void fifteen_fifteen() {
        givenTeamScore(1, 1);
        assertionCurrentScore("fifteen-all");
    }

    @Test
    void fifteen_thirty() {
        givenTeamScore(1, 2);
        assertionCurrentScore("fifteen-thirty");
    }

    @Test
    void fifteen_forty() {
        givenTeamScore(1, 3);
        assertionCurrentScore("fifteen-forty");
    }

    @Test
    void thirty_zero() {
        givenTeamScore(2, 0);
        assertionCurrentScore("thirty-love");
    }

    @Test
    void thirty_fifteen() {
        givenTeamScore(2, 1);
        assertionCurrentScore("thirty-fifteen");
    }

    @Test
    void thirty_thirty() {
        givenTeamScore(2, 2);
        assertionCurrentScore("thirty-all");
    }

    @Test
    void thirty_forty() {
        givenTeamScore(2, 3);
        assertionCurrentScore("thirty-forty");
    }
    @Test
    void forty_zero() {
        givenTeamScore(3, 0);
        assertionCurrentScore("forty-love");
    }


    @Test
    void forty_fifteen() {
        givenTeamScore(3, 1);
        assertionCurrentScore("forty-fifteen");
    }


    @Test
    void forty_thirty() {
        givenTeamScore(3, 2);
        assertionCurrentScore("forty-thirty");
    }

    @Test
    void forty_forty() {
        givenTeamScore(3, 3);
        assertionCurrentScore("deuce");
    }

    @Test
    void a_win() {
        givenTeamScore(4, 2);
        assertionCurrentScore("a win");
    }

    @Test
    void b_win(){
        givenTeamScore(2, 4);
        assertionCurrentScore("b win");
    }


    @Test
    void a_advantage() {
        givenTeamScore(4, 3);
        assertionCurrentScore("a adv");
    }

    @Test
    void a_advantage_before_win() {
        forty_forty();
        givenTeamScore(2, 0);
        assertionCurrentScore("a win");
    }
    @Test
    void a_advantage_before_deuce() {
        givenTeamScore(4, 4);
        assertionCurrentScore("deuce");
    }

    @Test
    void a_advantage_before_deuce_advantage() {
        givenTeamScore(5, 4);
        assertionCurrentScore("a adv");
    }

    @Test
    void b_advantage() {
        givenTeamScore(3, 4);
        assertionCurrentScore("b adv");
    }


    @Test
    void b_advantage_before_win() {
        givenTeamScore(3, 5);
        assertionCurrentScore("b win");
    }

    @Test
    void b_advantage_before_deuce() {
        givenTeamScore(4, 4);
        assertionCurrentScore("deuce");
    }

    @Test
    void b_advantage_before_deuce_advantage() {
        givenTeamScore(4, 5);
        assertionCurrentScore("b adv");
    }

}