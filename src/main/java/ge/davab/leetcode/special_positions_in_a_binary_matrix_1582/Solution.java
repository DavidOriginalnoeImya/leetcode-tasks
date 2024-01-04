package ge.davab.leetcode.special_positions_in_a_binary_matrix_1582;

class Solution {
    public int numSpecial(int[][] mat) {
        int specialNumCount = 0;

        for (int index1 = 0; index1 < mat.length; ++index1) {
            for (int index2 = 0; index2 < mat[index1].length; ++index2) {
                if (mat[index1][index2] == 1) {
                    if (specialRow(index1, index2, mat) && specialCol(index2, index1, mat)) {
                        ++specialNumCount;
                    }
                }
            }
        }

        return specialNumCount;
    }

    private boolean specialRow(int row, int elCol, int[][] mat) {
        for (int index = 0; index < mat[row].length; ++index) {
            if (mat[row][index] != 0 && index != elCol) {
                return false;
            }
        }

        return true;
    }

    private boolean specialCol(int col, int elRow, int[][] mat) {
        for (int index = 0; index < mat.length; ++index) {
            if (mat[index][col] != 0 && index != elRow) {
                return false;
            }
        }

        return true;
    }
}
