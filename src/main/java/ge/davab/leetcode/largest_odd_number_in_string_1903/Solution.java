package ge.davab.leetcode.largest_odd_number_in_string_1903;

class Solution {
    public String largestOddNumber(String num) {
        for (int index = num.length() - 1; index >= 0; --index) {
            if ((num.charAt(index) - 48) % 2 != 0) {
                return num.substring(0, index + 1);
            }
        }

        return "";
    }
}