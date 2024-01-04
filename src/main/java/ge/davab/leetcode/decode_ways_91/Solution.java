package ge.davab.leetcode.decode_ways_91;

import java.util.Set;

class Solution {
    public int numDecodings(String s) {
        Set<String> nums = Set.of(
                "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21",
                "22", "23", "24", "25", "26"
        );

        if (!nums.contains(s.substring(0, 1))) return 0;

        int oneDigNumEnd = 1, twoDigNumEnd = 0;

        for (int index = 1; index < s.length(); ++index) {
            int _oneDigNumEnd = oneDigNumEnd;

            if (nums.contains(s.substring(index, index + 1))) {
                oneDigNumEnd = oneDigNumEnd + twoDigNumEnd;
            } else {
                oneDigNumEnd = 0;
            }

            if (nums.contains(s.substring(index - 1, index + 1))) {
                twoDigNumEnd = _oneDigNumEnd;
            } else {
                twoDigNumEnd = 0;
            }
        }

        return oneDigNumEnd + twoDigNumEnd;
    }
}
