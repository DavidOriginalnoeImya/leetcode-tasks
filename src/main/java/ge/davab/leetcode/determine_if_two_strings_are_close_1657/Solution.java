package ge.davab.leetcode.determine_if_two_strings_are_close_1657;

import java.util.Arrays;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] w1ChCount = new int[26], w2ChCount = new int[26];

        for (int i = 0; i < word1.length(); ++i) {
            ++w1ChCount[word1.charAt(i) - 'a'];
            ++w2ChCount[word2.charAt(i) - 'a'];
        }

        for (int i = 0; i < 26; ++i) {
            if ((w1ChCount[i] == 0 ^ w2ChCount[i] != 0) ||
                    w1ChCount[i] != 0 && w2ChCount[i] == 0) return false;
        }

        for (int i = 0; i < 26; ++i) {
            int j = i;

            for (; j < 26 && w1ChCount[j] != w2ChCount[i]; ++j);

            if (j < 26) {
                int tmp = w1ChCount[j];
                w1ChCount[j] = w1ChCount[i];
                w1ChCount[i] = tmp;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.closeStrings("ab", "ac"));
    }
}
