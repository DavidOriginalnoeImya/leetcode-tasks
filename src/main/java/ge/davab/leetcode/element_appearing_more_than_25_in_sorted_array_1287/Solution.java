package ge.davab.leetcode.element_appearing_more_than_25_in_sorted_array_1287;

class Solution {
    public int findSpecialInteger(int[] arr) {
        int specialInt = -1, count = 0;

        for (int curInt: arr) {
            if (curInt == specialInt) {
                ++count;

                if (count > (double) arr.length / 4) return curInt;
            } else {
                specialInt = curInt;
                count = 1;
            }
        }

        return specialInt;
    }
}
