package ge.davab.leetcode.largest_substring_between_two_equal_characters_1624;

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] chPos = new int[26];

        for (int index = 0; index < chPos.length; ++index) {
            chPos[index] = -1;
        }

        int maxLength = -1;

        for (int index = 0; index < s.length(); ++index) {
            int curPos = s.charAt(index) - 97;

            if (chPos[curPos] == -1) {
                chPos[curPos] = index;
            }
            else if (index - chPos[curPos] - 1 > maxLength) {
                maxLength = index - chPos[curPos] - 1;
            }
        }

        return maxLength;
    }
}
