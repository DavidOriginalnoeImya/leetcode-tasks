package ge.davab.leetcode.spiral_matrix_54;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int spiralLength = matrix.length * matrix[0].length;

        matrix = getEdgedMatrix(matrix);

        List<Integer> spiralMatrix = new LinkedList<>();

        int row = 1, col = 1, rowDiff = 1, colDiff = 1;

        boolean rowChange = false;

        for (int index = 0; index < spiralLength; ++index) {
            spiralMatrix.add(matrix[row][col]);
            matrix[row][col] = 101;

            if (rowChange) {
                if (matrix[row + rowDiff][col] != 101) {
                    row += rowDiff;
                } else {
                    rowChange = false;
                    rowDiff *= -1; col += colDiff;
                }
            } else {
                if (matrix[row][col + colDiff] != 101) {
                    col += colDiff;
                } else {
                    rowChange = true;
                    colDiff *= -1; row += rowDiff;
                }
            }
        }

        return spiralMatrix;
    }

    private int[][] getEdgedMatrix(int[][] matrix) {
        int[][] edgedMatrix = new int[matrix.length + 2][matrix[0].length + 2];

        for (int row = 0; row < edgedMatrix.length; ++row) {
            for (int col = 0; col < edgedMatrix[0].length; ++col) {
                edgedMatrix[row][col] = 101;

                if (row - 1 >= 0 && row - 1 < matrix.length && col - 1 >= 0 && col - 1 < matrix[0].length) {
                    edgedMatrix[row][col] = matrix[row - 1][col - 1];
                }
            }
        }

        return edgedMatrix;
    }
}
