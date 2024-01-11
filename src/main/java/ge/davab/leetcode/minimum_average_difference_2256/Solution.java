package ge.davab.leetcode.minimum_average_difference_2256;

class Solution {

    public int minimumAverageDifference(int[] nums) {
        long rightSum = 0; int rightCount = nums.length;

        for (int num: nums) rightSum += num;

        long leftSum = 0; int leftCount = 0;

        long minAvgDiff = Integer.MAX_VALUE; int minAvgIndex = 0;

        for (int i = 1; i < nums.length; ++i) {
            leftSum += nums[i - 1]; ++leftCount;
            rightSum -= nums[i - 1]; --rightCount;

            long curAvgDiff = Math.abs(leftSum / leftCount - rightSum / rightCount);

            if (curAvgDiff < minAvgDiff) {
                minAvgDiff = curAvgDiff;
                minAvgIndex = i - 1;
            }
        }

        leftSum += nums[leftCount];

        return leftSum / nums.length < minAvgDiff ? leftCount : minAvgIndex;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumAverageDifference(new int[] {0,6}));
    }
}
