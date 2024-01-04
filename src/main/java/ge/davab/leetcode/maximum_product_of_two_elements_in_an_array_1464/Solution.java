package ge.davab.leetcode.maximum_product_of_two_elements_in_an_array_1464;

class Solution {
    public int maxProduct(int[] nums) {
        int firstMax = 0, secondMax = 0;

        for (int num : nums) {
            if (num > firstMax) {
                secondMax = firstMax;
                firstMax = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }

        return (firstMax - 1) * (secondMax - 1);
    }
}
