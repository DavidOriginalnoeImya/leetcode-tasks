package ge.davab.leetcode.triangle_120;

import java.util.Arrays;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);

        int[] curNums = { triangle.get(0).get(0) };

        for (int index1 = 1; index1 < triangle.size(); ++index1) {
            int[] newNums = new int[triangle.get(index1).size()];
            Arrays.fill(newNums, Integer.MAX_VALUE);

            for (int index2 = 0; index2 < curNums.length; ++index2) {
                if (curNums[index2] + triangle.get(index1).get(index2) < newNums[index2]) {
                    newNums[index2] = curNums[index2] + triangle.get(index1).get(index2);
                }
                newNums[index2 + 1] = curNums[index2] + triangle.get(index1).get(index2 + 1);
            }
            curNums = newNums;
        }

        int minTotal = Integer.MAX_VALUE;

        for (int curNum: curNums) {
            if (curNum < minTotal) minTotal = curNum;
        }

        return minTotal;
    }
}
