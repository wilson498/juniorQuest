package org.example.leetcode;

import org.example.leetcode.quest.Quest18;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = LeetcodeApplication.class)
public class Quest18Test {

    @Autowired
    public Quest18 quest18;


    @Test
    public void case1Test() {
        List<List<Integer>> result = quest18.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        assert List.of(
                List.of(-2, -1, 1, 2),
                List.of(-2, 0, 0, 2),
                List.of(-1, 0, 0, 1)
        ).equals(result);
    }

    @Test
    public void case2Test() {
        List<List<Integer>> result = quest18.fourSum(new int[]{2, 2, 2, 2, 2}, 8);
        assert List.of(List.of(2, 2, 2, 2)).equals(result);
    }
}
