package ge.davab.leetcode.max_consecutive_ones_485;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;

        for (int num: nums) {
            if (num == 1) {
                ++cur;
            } else {
                if (cur > max) max = cur;
                cur = 0;
            }
        }

        return max;
    }
}
