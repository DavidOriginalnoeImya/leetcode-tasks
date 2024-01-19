package ge.davab.leetcode.reverse_vowels_of_a_string_345;

class Solution {
    public String reverseVowels(String s) {
        boolean[] vowels = new boolean[128];
        vowels['a'] = true; vowels['e'] = true; vowels['i'] = true; vowels['o'] = true; vowels['u'] = true;
        vowels['A'] = true; vowels['E'] = true; vowels['I'] = true; vowels['O'] = true; vowels['U'] = true;
        
        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            if (vowels[s.charAt(i)]) strBuilder.append(s.charAt(i));
        }

        String sVowels = strBuilder.toString();
        strBuilder = new StringBuilder();
        int curVowel = sVowels.length() - 1;

        for (int i = 0; i < s.length(); ++i) {
            char curChar = s.charAt(i);
            if (vowels[curChar]) curChar = sVowels.charAt(curVowel--);
            strBuilder.append(curChar);
        }

        return strBuilder.toString();
    }
}
