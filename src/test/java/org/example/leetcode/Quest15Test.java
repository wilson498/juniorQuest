package org.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest(classes = LeetcodeApplication.class)
public class Quest15Test {


    @Autowired
    public Quest15 quest15;

    @Test
    public void testCase1() {
        List<List<Integer>> result = quest15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        Assertions.assertEquals(List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)),(result));
    }

    @Test
    public void testCase2() {
        List<List<Integer>> result = quest15.threeSum(new int[]{0, 1, 1});
        assert (List.of().equals(result));
    }

    @Test
    public void testCase3() {
        List<List<Integer>> result = quest15.threeSum(new int[]{0, 0, 0});
        assert (List.of(List.of(0, 0, 0)).equals(result));
    }
}
