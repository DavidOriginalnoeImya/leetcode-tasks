package ge.davab.leetcode.detect_capital_520;

class Solution {
    public boolean detectCapitalUse(String word) {
        int capitalNum = 0;

        for (int i = 0; i < word.length(); ++i) {
            char curChar = word.charAt(i);
            if (curChar >= 65 && curChar <= 90) ++capitalNum;
        }

        boolean isFirstCapital = word.charAt(0) >= 65 && word.charAt(0) <= 90;

        if (isFirstCapital && (capitalNum == word.length() - 1 || capitalNum == 0)) return true;
        return !isFirstCapital && capitalNum == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.detectCapitalUse("USA");
    }
}
