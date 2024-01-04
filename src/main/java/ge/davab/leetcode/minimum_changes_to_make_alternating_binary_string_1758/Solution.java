package ge.davab.leetcode.minimum_changes_to_make_alternating_binary_string_1758;

class Solution {
    public int minOperations(String s) {
        int[] zeroOne = {1, 0};
        int minWithZeroBeg = 0, minWithOneBeg = 0;
        int curChWithZero = 0, curChWithOne = 1;

        for (int index = 0; index < s.length(); ++index) {
            if (s.charAt(index) - 48 != curChWithZero) ++minWithZeroBeg;
            if (s.charAt(index) - 48 != curChWithOne) ++minWithOneBeg;
            curChWithZero = zeroOne[curChWithZero];
            curChWithOne = zeroOne[curChWithOne];
        }

        return minWithOneBeg < minWithZeroBeg ? minWithOneBeg : minWithZeroBeg;
    }
}
