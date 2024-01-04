package ge.davab.leetcode.largest_3_same_digit_number_in_string_2264;

class Solution {
    public String largestGoodInteger(String num) {
        int count = 1, max = -1;

        for (int index = 1; index < num.length(); ++index) {
            if (num.charAt(index) == num.charAt(index - 1)) {
                ++count;

                if (count == 3 && num.charAt(index) - 48 > max) {
                    max = num.charAt(index) - 48;
                }
            }
            else {
                count = 1;
            }
        }

        return max > -1 ? String.valueOf(max).repeat(3) : "";
    }
}
