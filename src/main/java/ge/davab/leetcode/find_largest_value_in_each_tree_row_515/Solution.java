package ge.davab.leetcode.find_largest_value_in_each_tree_row_515;

import ge.davab.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

class Solution {

    private final List<Integer> largestValues = new LinkedList<>();

    public List<Integer> largestValues(TreeNode root) {
        largestValues(root, 0);
        return largestValues;
    }

    private void largestValues(TreeNode root, int row) {
        if (root != null) {
            if (row < largestValues.size()) {
                largestValues.set(row, Math.max(root.val, largestValues.get(row)));
            } else {
                largestValues.add(root.val);
            }

            largestValues(root.left, ++row);
            largestValues(root.right, row);
        }
    }
}
