package ge.davab.leetcode.widest_vertical_area_between_two_points_containing_no_points_1637;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(p -> p[0]));

        int maxWidth = 0;

        for (int index = 1; index < points.length; ++index) {
            int width = points[index][0] - points[index - 1][0];

            if (width > maxWidth) {
                maxWidth = width;
            }
        }

        return maxWidth;
    }
}
