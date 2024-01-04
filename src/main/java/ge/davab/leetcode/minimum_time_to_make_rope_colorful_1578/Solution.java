package ge.davab.leetcode.minimum_time_to_make_rope_colorful_1578;

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minCost = 0, prevColorTime = neededTime[0];

        for (int index = 1; index < colors.length(); ++index) {
            if (colors.charAt(index - 1) == colors.charAt(index)) {
                if (neededTime[index] > prevColorTime) {
                    minCost += prevColorTime;
                    prevColorTime = neededTime[index];
                } else {
                    minCost += neededTime[index];
                }
            } else {
                prevColorTime = neededTime[index];
            }
        }

        return minCost;
    }
}
