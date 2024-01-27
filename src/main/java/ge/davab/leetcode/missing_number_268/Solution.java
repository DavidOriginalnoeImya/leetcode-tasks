package ge.davab.leetcode.missing_number_268;

class Solution {
    public int missingNumber(int[] nums) {
        int sum = (int)((1 + nums.length) * (double)nums.length / 2);

        for (int num: nums) {
            sum -= num;
        }

        return sum;
    }
}
