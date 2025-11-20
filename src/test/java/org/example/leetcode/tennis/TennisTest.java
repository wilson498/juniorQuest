package org.example.leetcode.tennis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TennisTest {


    private Tennis tennis;


    private void givenAScore(Tennis tennis, int count) {
        for (int i = 0; i < count; i++) {
            tennis.teamAScore();
        }
    }

    private void givenBScore(Tennis tennis, int count) {
        for (int i = 0; i < count; i++) {
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

        givenAScore(tennis, 1);
        Assertions.assertEquals("fifteen-love", tennis.getCurrentScore());
    }

    @Test
    void fifteen_fifteen() {
        givenAScore(tennis, 1);
        givenBScore(tennis, 1);
        Assertions.assertEquals("fifteen-all", tennis.getCurrentScore());
    }

    @Test
    void forty_thirty() {
        givenAScore(tennis, 3);
        givenBScore(tennis, 2);
        Assertions.assertEquals("forty-thirty", tennis.getCurrentScore());
    }

    @Test
    void forty_forty() {
        givenAScore(tennis, 3);
        givenBScore(tennis, 3);
        Assertions.assertEquals("deuce", tennis.getCurrentScore());
    }

    @Test
    void a_advantage() {
        givenAScore(tennis, 4);
        givenBScore(tennis, 3);
        Assertions.assertEquals("a adv", tennis.getCurrentScore());
    }

    @Test
    void a_win() {
        givenAScore(tennis, 4);
        givenBScore(tennis, 2);
        Assertions.assertEquals("a win", tennis.getCurrentScore());
    }

    @Test
    void a_advantage_before_win() {
        givenAScore(tennis, 5);
        givenBScore(tennis, 3);
        Assertions.assertEquals("a win", tennis.getCurrentScore());

    }
}