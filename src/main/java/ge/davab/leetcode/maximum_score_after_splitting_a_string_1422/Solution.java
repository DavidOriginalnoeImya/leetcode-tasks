package ge.davab.leetcode.maximum_score_after_splitting_a_string_1422;

class Solution {
    public int maxScore(String s) {
        int curScore = s.charAt(0) == '0' ? 1 : 0;

        for (int index = 1; index < s.length(); ++index) {
            if (s.charAt(index) == '1') ++curScore;
        }

        int maxScore = curScore;

        for (int index = 1; index < s.length() - 1; ++index) {
            if (s.charAt(index) == '0') ++curScore;
            else --curScore;

            if (curScore > maxScore) {
                maxScore = curScore;
            }
        }

        return maxScore;
    }
}
