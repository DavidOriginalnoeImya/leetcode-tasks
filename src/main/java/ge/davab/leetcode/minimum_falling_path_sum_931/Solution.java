package ge.davab.leetcode.minimum_falling_path_sum_931;

import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for (int i = 1; i < matrix.length; ++i) {
            int[] paths = new int[matrix.length];

            for (int p = 0; p < paths.length; ++p) {
                paths[p] = matrix[i][p];
            }

            matrix[i][0] += matrix[i - 1][0]; matrix[i][1] += matrix[i - 1][0];

            for (int j = 1; j < matrix.length; ++j) {
                for (int x = -1; x <= 0; ++x) {
                    int path = matrix[i - 1][j] + paths[j + x];

                    if (path < matrix[i][j + x]) {
                        matrix[i][j + x] = path;
                    }
                }

                if (j != matrix.length - 1) {
                    matrix[i][j + 1] = matrix[i - 1][j] + paths[j + 1];
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[matrix.length - 1][i] < min) {
                min = matrix[matrix.length - 1][i];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.minFallingPathSum(new int[][] {{1}}));
    }
}
