package ge.davab.leetcode.minimum_number_of_steps_to_make_two_strings_anagram_1347;

import java.util.Arrays;

class Solution {
    public int minSteps(String s, String t) {
        int[] chDiff = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            ++chDiff[s.charAt(i) - 'a'];
            --chDiff[t.charAt(i) - 'a'];
        }

        int steps = 0;

        for (int diff: chDiff) {
            if (diff > 0)
                steps += diff;
        }

        return steps;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSteps("leetcode", "practice"));
    }
}
