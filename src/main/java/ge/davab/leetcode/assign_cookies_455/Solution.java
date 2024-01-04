package ge.davab.leetcode.assign_cookies_455;

import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); Arrays.sort(s);

        int childrenContent = 0, curGreed = 0, curSize = 0;

        while (curGreed < g.length && curSize < s.length) {
            if (s[curSize++] >= g[curGreed]) {
                ++childrenContent; ++curGreed;
            }
        }

        return childrenContent;
    }
}
