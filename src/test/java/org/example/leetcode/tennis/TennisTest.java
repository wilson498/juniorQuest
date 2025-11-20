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

    private void assertionCurrentScore(String expected) {
        Assertions.assertEquals(expected, tennis.getCurrentScore());
    }

    @Test
    void zero_zero() {
        assertionCurrentScore("love-all");
    }

    @Test
    void zero_fifteen() {
        giveTeamScore(0, 1);
        assertionCurrentScore("love-fifteen");
    }

    @Test
    void zero_thirty() {
        giveTeamScore(0, 2);
        assertionCurrentScore("love-thirty");
    }

    @Test
    void zero_forty() {
        giveTeamScore(0, 3);
        assertionCurrentScore("love-forty");
    }

    @Test
    void fifteen_zero() {
        giveTeamScore(1, 0);
        assertionCurrentScore("fifteen-love");
    }

    @Test
    void fifteen_fifteen() {
        giveTeamScore(1, 1);
        assertionCurrentScore("fifteen-all");
    }

    @Test
    void fifteen_thirty() {
        giveTeamScore(1, 2);
        assertionCurrentScore("fifteen-thirty");
    }

    @Test
    void fifteen_forty() {
        giveTeamScore(1, 3);
        assertionCurrentScore("fifteen-forty");
    }

    @Test
    void thirty_zero() {
        giveTeamScore(2, 0);
        assertionCurrentScore("thirty-love");
    }

    @Test
    void thirty_fifteen() {
        giveTeamScore(2, 1);
        assertionCurrentScore("thirty-fifteen");
    }

    @Test
    void thirty_thirty() {
        giveTeamScore(2, 2);
        assertionCurrentScore("thirty-all");
    }

    @Test
    void thirty_forty() {
        giveTeamScore(2, 3);
        assertionCurrentScore("thirty-forty");
    }
    @Test
    void forty_zero() {
        giveTeamScore(3, 0);
        assertionCurrentScore("forty-love");
    }


    @Test
    void forty_fifteen() {
        giveTeamScore(3, 1);
        assertionCurrentScore("forty-fifteen");
    }


    @Test
    void forty_thirty() {
        giveTeamScore(3, 2);
        assertionCurrentScore("forty-thirty");
    }

    @Test
    void forty_forty() {
        giveTeamScore(3, 3);
        assertionCurrentScore("deuce");
    }

    @Test
    void same_score_over_four_count() {
        giveTeamScore(5, 5);
        assertionCurrentScore("deuce");
    }

    @Test
    void a_six_score_advantage() {
        giveTeamScore(6, 5);
        assertionCurrentScore("a adv");
    }

    @Test
    void a_six_score_win() {
        giveTeamScore(6, 4);
        assertionCurrentScore("a win");
    }



    @Test
    void a_win() {
        giveTeamScore(4, 2);
        assertionCurrentScore("a win");
    }

    @Test
    void a_advantage() {
        giveTeamScore(4, 3);
        assertionCurrentScore("a adv");
    }

    @Test
    void a_advantage_before_win() {
        giveTeamScore(5, 3);
        assertionCurrentScore("a win");
    }
    @Test
    void a_advantage_before_deuce() {
        giveTeamScore(4, 4);
        assertionCurrentScore("deuce");
    }

    @Test
    void a_advantage_before_deuce_advantage() {
        giveTeamScore(5, 4);
        assertionCurrentScore("a adv");
    }

    @Test
    void b_win(){
        giveTeamScore(2, 4);
        assertionCurrentScore("b win");
    }

    @Test
    void b_advantage() {
        giveTeamScore(3, 4);
        assertionCurrentScore("b adv");
    }


    @Test
    void b_advantage_before_win() {
        giveTeamScore(3, 5);
        assertionCurrentScore("b win");
    }

    @Test
    void b_advantage_before_deuce() {
        giveTeamScore(4, 4);
        assertionCurrentScore("deuce");
    }

    @Test
    void b_advantage_before_deuce_advantage() {
        giveTeamScore(4, 5);
        assertionCurrentScore("b adv");
    }

}