package ge.davab.leetcode.grid_game_2017;

class Solution {
    public long gridGame(int[][] grid) {
        long topRowSum = 0;

        for (int col = 1; col < grid[0].length; ++col) {
            topRowSum += grid[0][col];
        }

        long bottomRowSum = 0, maxSum = topRowSum;

        for (int col = 1; col < grid[0].length; ++col) {
            topRowSum -= grid[0][col];
            bottomRowSum += grid[1][col - 1];

            long max = Math.max(topRowSum, bottomRowSum);

            if (max < maxSum) maxSum = max;
        }

        return maxSum;
    }
}
