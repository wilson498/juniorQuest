package org.example.leetcode;

import org.example.leetcode.quest.Quest12;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Quest12Test {

    @Autowired
    private Quest12 quest12;

    @Test
    public void case1Test() {
        String result = quest12.intToRoman(3749);
        Assertions.assertEquals("MMMDCCXLIX", result);
    }

    @Test
    public void case2Test() {
        String result = quest12.intToRoman(58);
        assert "LVIII".equals(result);
    }

    @Test
    public void case3Test() {
        String result = quest12.intToRoman(1994);
        assert "MCMXCIV".equals(result);
    }

    @Test
    public void case4Test() {
        String result = quest12.intToRoman(91994);
        Assertions.assertEquals("PJMCMXCIV", result);
    }


    @Test
    public void case5Test() {
        String result = quest12.intToRoman(3);
        Assertions.assertEquals("III", result);
    }
}
