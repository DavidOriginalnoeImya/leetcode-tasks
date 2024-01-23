package ge.davab.leetcode.maximum_length_of_a_concatenated_string_with_unique_characters_1239;

import java.util.List;

class Solution {
    public int maxLength(List<String> arr) {
        int[][] chFreq = new int[arr.size()][26];

        for (int i = 0; i < arr.size(); ++i) {
            String word = arr.get(i);

            for (int j = 0; j < word.length(); ++j) {
                ++chFreq[i][word.charAt(j) - 'a'];
            }
        }

        int maxLen = 0;

        for (int i = 0; i < arr.size(); ++i) {
            int curLen = maxLength(arr, chFreq, addChFreq(new int[26], chFreq[i]), i);
            if (curLen > maxLen) maxLen = curLen;
        }

        return maxLen;
    }

    private int maxLength(List<String> arr, int[][] chFreq, int[] sumFreq, int curWord) {
        if (!containDiffChars(chFreq[curWord])) return 0;

        int curLen = arr.get(curWord).length(), maxLen = curLen;

        for (int i = curWord + 1; i < chFreq.length; ++i) {
            if (containDiffChars(sumFreq, chFreq[i])) {
                curLen += maxLength(arr, chFreq, addChFreq(sumFreq, chFreq[i]), i);
            }

            if (curLen > maxLen) maxLen = curLen;
            curLen = arr.get(curWord).length();
        }

        return maxLen;
    }

    private boolean containDiffChars(int[] chFr1) {
        for (int ch = 0; ch < 26; ++ch) {
            if (chFr1[ch] > 1) return false;
        }

        return true;
    }

    private boolean containDiffChars(int[] chFr1, int[] chFr2) {
        for (int ch = 0; ch < 26; ++ch) {
            if ((chFr1[ch] * chFr2[ch]) != 0) return false;
        }

        return true;
    }

    private int[] addChFreq(int[] chFr1, int[] chFr2) {
        int[] sumFreq = new int[26];

        for (int ch = 0; ch < 26; ++ch) {
            sumFreq[ch] = chFr1[ch] + chFr2[ch];
        }

        return sumFreq;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxLength(List.of("a", "bb")));
    }
}
