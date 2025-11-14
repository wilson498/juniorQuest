package org.example.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class Quest12 {

    private final Map<Integer, String> map = new HashMap<>();
    private final List<Integer> numbers;

    public Quest12() {
        //假設性擴充羅馬數字
        map.put(100000, "J");
        map.put(90000, "PJ");
        map.put(50000, "U");
        map.put(40000, "PU");
        map.put(10000, "P");
        map.put(9000, "MP");
        map.put(5000, "O");
        map.put(4000, "MO");
        //-------假設性擴充結束
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        numbers = new ArrayList<>(map.keySet());
        numbers.sort(Comparator.reverseOrder());
    }

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        for (Integer integer : numbers) {
            while (num >= integer) {
                result.append(map.get(integer));
                num -= integer;
            }
        }
        log.info("result:{}", result);
        return result.toString();
    }
}
