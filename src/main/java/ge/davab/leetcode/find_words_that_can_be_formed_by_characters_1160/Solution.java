package ge.davab.leetcode.find_words_that_can_be_formed_by_characters_1160;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countCharacters(String[] words, String chars) {
        int count = 0;

        Map<Character, Integer> charsNum = getStrCharsNum(chars);

        for (String word: words) {
            Map<Character, Integer> wordCharsNum = new HashMap<>();

            boolean isGoodStr = true;

            for (int index = 0; index < word.length() && isGoodStr; ++index) {
                int curCount = wordCharsNum.getOrDefault(
                        word.charAt(index), charsNum.getOrDefault(word.charAt(index), 0)
                );
                --curCount;

                if (curCount < 0)
                    isGoodStr = false;
                else
                    wordCharsNum.put(word.charAt(index), curCount);
            }

            if (isGoodStr) count += word.length();
        }

        return count;
    }

    private Map<Character, Integer> getStrCharsNum(String str) {
        Map<Character, Integer> charsNum = new HashMap<>();

        for (int index = 0; index < str.length(); ++index) {
            charsNum.put(str.charAt(index), charsNum.getOrDefault(str.charAt(index), 0) + 1);
        }

        return charsNum;
    }
}
