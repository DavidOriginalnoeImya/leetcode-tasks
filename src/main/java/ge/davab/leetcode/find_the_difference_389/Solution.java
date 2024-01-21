package ge.davab.leetcode.find_the_difference_389;

class Solution {
    public char findTheDifference(String s, String t) {
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            ++chars[s.charAt(i) - 'a']; --chars[t.charAt(i) - 'a'];
        }

        --chars[t.charAt(t.length() - 1) - 'a'];

        int i = 0;

        for (; i < 26 && chars[i] != -1; ++i);

        return (char)(i + 'a');
    }
}