package ge.davab.leetcode.two_sum_1;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pos = new HashMap<>();

        for (int index = 0; index < nums.length; ++index) {
            if (!pos.containsKey(target - nums[index])) {
                pos.put(nums[index], index);
            }
            else return new int[] {pos.get(target - nums[index]), index};
        }

        return null;
    }
}