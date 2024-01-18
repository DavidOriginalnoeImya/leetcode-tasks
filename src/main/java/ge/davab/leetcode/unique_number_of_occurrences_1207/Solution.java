package ge.davab.leetcode.unique_number_of_occurrences_1207;

import java.util.Arrays;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] occurrences = new int[2001];

        for (int num: arr) {
            ++occurrences[num + 1000];
        }

        int[] occNum = new int[1001];


        for (int occurrence: occurrences) {
            if (++occNum[occurrence] > 1 && occurrence > 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniqueOccurrences(new int[]{1,2,2,1,1,3}));
    }
}
