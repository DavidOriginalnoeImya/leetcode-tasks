package ge.davab.leetcode.convert_an_array_into_a_2d_array_with_conditions_2610;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> matrix = new LinkedList<>();
        int[] rowNumbers = new int[200];

        for (int num: nums) {
            if (rowNumbers[num - 1] == matrix.size()) {
                matrix.add(new LinkedList<>());
            }
            matrix.get(rowNumbers[num - 1]++).add(num);
        }

        return matrix;
    }
}
