package ge.davab.leetcode.find_substring_with_given_hash_value_2156;

class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        long[] powers = new long[k]; powers[0] = 1;
        long curSubStrHash = val(s.charAt(0)) % modulo;

        for (int i = 1; i < k; ++i) {
            powers[i] = (powers[i - 1] % modulo) * (power % modulo);
            curSubStrHash += ((val(s.charAt(i)) % modulo) * (powers[i] % modulo)) % modulo;
        }

        if (curSubStrHash % modulo == hashValue) return s.substring(0, k);

        for (int i = 1; i <= s.length() - k; ++i) {
            curSubStrHash = 0;

            for (int j = 0; j < k; ++j) {
                curSubStrHash += ((val(s.charAt(i + j)) % modulo) * (powers[j] % modulo)) % modulo;
            }

            if (curSubStrHash % modulo == hashValue)
                return s.substring(i, i + k);
        }

        return s.substring(s.length() - k);
    }

    private int val(char c) {
        return c - 96;
    }
}
