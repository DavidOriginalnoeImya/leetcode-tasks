package ge.davab.leetcode.maximum_product_difference_between_two_pairs_1913;

class Solution {
    public int maxProductDifference(int[] nums) {
        int fMax = 0, sMax = 0;
        int fMin = Integer.MAX_VALUE, sMin = Integer.MAX_VALUE;

        for (int num: nums) {
            if (num > fMax) {
                sMax = fMax; fMax = num;
            } else if (num > sMax) {
                sMax = num;
            }

            if (num < fMin) {
                sMin = fMin; fMin = num;
            } else if (num < sMin) {
                sMin = num;
            }
        }

        return fMax * sMax - fMin * sMin;
    }
}
