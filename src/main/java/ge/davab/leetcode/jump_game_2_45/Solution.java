package ge.davab.leetcode.jump_game_2_45;

class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;

        int jumpNum = 0, curIndex = 0, endIndex = nums.length - 1;

        while (nums[curIndex] < endIndex - curIndex) {
            ++jumpNum;
            curIndex = getMaxPos(nums, curIndex + 1, curIndex + nums[curIndex]);
        }

        return ++jumpNum;
    }

    private int getMaxPos(int[] nums, int beg, int end) {
        int max = Integer.MIN_VALUE, maxPos = 0;

        for (int index = beg; index <= end; ++index) {
            if (max <= nums[index] + index) {
                max = nums[index] + index;
                maxPos = index;
            }
        }

        return maxPos;
    }
}
