package ge.davab.leetcode.longest_common_prefix_14;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; ++i) {
            int j = 0; int len = Math.min(prefix.length(), strs[i].length());
            while (j < len && strs[i].charAt(j) == prefix.charAt(j)) ++j;
            prefix = strs[i].substring(0, j);
            if (prefix.isEmpty()) return "";
        }

        return prefix;
    }
}
