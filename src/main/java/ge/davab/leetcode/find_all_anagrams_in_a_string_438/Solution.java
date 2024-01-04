package ge.davab.leetcode.find_all_anagrams_in_a_string_438;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return List.of();

        int[] pChars = new int[26];
        int[] sChars = new int[26];

        for (int index = 0; index < p.length(); ++index) {
            ++pChars[p.charAt(index) - 97];
            ++sChars[s.charAt(index) - 97];
        }

        List<Integer> anagramsPos = new LinkedList<>();

        if (isArraysEqual(pChars, sChars)) anagramsPos.add(0);

        for (int index = p.length(); index < s.length(); ++index) {
            int pos = s.charAt(index) - 97;
            ++sChars[pos];
            --sChars[s.charAt(index - p.length()) - 97];

            if (sChars[pos] == pChars[pos] && isArraysEqual(pChars, sChars))
                anagramsPos.add(index - p.length() + 1);
        }

        return anagramsPos;
    }

    private boolean isArraysEqual(int[] pChars, int[] sChars) {
        for (int index = 0; index < pChars.length; ++index) {
            if (pChars[index] != sChars[index]) return false;
        }

        return true;
    }
}