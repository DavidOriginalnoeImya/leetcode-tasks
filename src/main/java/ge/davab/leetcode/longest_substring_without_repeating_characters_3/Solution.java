package ge.davab.leetcode.longest_substring_without_repeating_characters_3;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] pos = new int[128];

        for (int i = 0; i < pos.length; ++i) {
            pos[i] = -1;
        }

        int maxLen = 0, subBeg = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (pos[s.charAt(i)] >= subBeg) {
                subBeg = pos[s.charAt(i)] + 1;
            }

            pos[s.charAt(i)] = i;
            int curLen = i - subBeg + 1;

            if (curLen > maxLen) maxLen = curLen;
        }

        return maxLen;
    }
}
