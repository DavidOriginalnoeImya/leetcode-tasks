package ge.davab.leetcode.minimum_time_visiting_all_points_1266;

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;

        for (int index = 1; index < points.length; ++index) {
            time += Math.max(
                    Math.abs(points[index][0] - points[index - 1][0]),
                    Math.abs(points[index][1] - points[index - 1][1])
            );
        }

        return time;
    }
}
