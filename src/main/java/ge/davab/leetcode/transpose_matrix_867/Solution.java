package ge.davab.leetcode.transpose_matrix_867;

class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] transpose = new int[matrix[0].length][matrix.length];

        for (int index1 = 0; index1 < matrix[0].length; ++index1) {
            for (int index2 = 0; index2 < matrix.length; ++index2) {
                transpose[index1][index2] = matrix[index2][index1];
            }
        }

        return transpose;
    }
}
