package ge.davab.leetcode.difference_between_ones_and_zeros_in_row_and_column_2482;

class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];

        for (int index1 = 0; index1 < grid.length; ++index1) {
            for (int index2 = 0; index2 < grid[index1].length; ++index2) {
                if (grid[index1][index2] == 1) {
                    ++rows[index1]; ++cols[index2];
                }
                else {
                    --rows[index1]; --cols[index2];
                }
            }
        }

        int[][] diff = new int[grid.length][grid[0].length];

        for (int index1 = 0; index1 < grid.length; ++index1) {
            for (int index2 = 0; index2 < grid[index1].length; ++index2) {
                diff[index1][index2] = rows[index1] + cols[index2];
            }
        }

        return diff;
    }
}
