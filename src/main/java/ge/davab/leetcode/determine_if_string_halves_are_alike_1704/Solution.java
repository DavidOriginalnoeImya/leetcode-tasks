package ge.davab.leetcode.determine_if_string_halves_are_alike_1704;

import java.util.Set;

class Solution {
    public boolean halvesAreAlike(String s) {
        boolean[] vowels = new boolean[122];
        vowels['a'] = true; vowels['e'] = true;
        vowels['i'] = true; vowels['o'] = true;
        vowels['u'] = true; vowels['A'] = true;
        vowels['E'] = true; vowels['I'] = true;
        vowels['O'] = true; vowels['U'] = true;
        int vowelCount = 0;

        for (int i = 0; i < s.length() / 2; ++i) {
            if (vowels[s.charAt(i)]) ++vowelCount;
        }

        for (int i = s.length() / 2; i < s.length(); ++i) {
            if (vowels[s.charAt(i)]) --vowelCount;
        }

        return vowelCount == 0;
    }
}
