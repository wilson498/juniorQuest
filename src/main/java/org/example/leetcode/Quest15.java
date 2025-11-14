package org.example.leetcode;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class Quest15 {


    public List<List<Integer>> threeSum(int[] nums) {
        ThreeSumCalculate threeSumCalculate = new ThreeSumCalculate(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int index = 0; index < threeSumCalculate.getSize() - 2; index++) {
            if (index > 0 && threeSumCalculate.get(index) == threeSumCalculate.get(index - 1)) {
                continue;
            }
            List<List<Integer>> list = threeSumCalculate.getTwoSum(index);
            result.addAll(list);
        }
        log.info("result:{}", result);
        return result;
    }

    public static class ThreeSumCalculate {

        private final int[] nums;
        @Getter
        private final int size;

        public ThreeSumCalculate(int[] nums) {
            Arrays.sort(nums);
            this.nums = nums;
            this.size = nums.length;
        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                throw new RuntimeException("index out of range");
            }
            return nums[index];
        }

        private List<List<Integer>> getTwoSum(int i) {
            if (i < 0 || i >= size) {
                throw new RuntimeException("index out of range");
            }
            int left = i + 1;
            int rigth = size - 1;
            int target = -nums[i];
            Set<List<Integer>> list = new HashSet<>();
            while (left < rigth) {
                int sum = nums[left] + nums[rigth];
                if (sum == target) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[rigth]));
                    left++;
                    rigth--;
                } else if (sum < target) {
                    left++;
                } else {
                    rigth--;
                }
            }
            return list.stream().toList();
        }

    }
}
