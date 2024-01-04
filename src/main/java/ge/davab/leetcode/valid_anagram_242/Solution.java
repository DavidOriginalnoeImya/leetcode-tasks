package ge.davab.leetcode.valid_anagram_242;

import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        byte[] sBytes = s.getBytes();
        Arrays.sort(sBytes);
        byte[] tBytes = t.getBytes();
        Arrays.sort(tBytes);

        return Arrays.equals(sBytes, tBytes);
    }
}
