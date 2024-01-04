package ge.davab.leetcode.redistribute_characters_to_make_all_strings_equal_1897;

import java.util.Arrays;

class Solution {
    public boolean makeEqual(String[] words) {
        int[] charNum = new int[26];

        for (String word: words) {
            for (int index = 0; index < word.length(); ++index) {
                ++charNum[word.charAt(index) - 97];
            }
        }

        System.out.println(Arrays.toString(charNum));

        for (int num: charNum) {
            if (num % words.length != 0) return false;
        }

        return true;
    }
}
