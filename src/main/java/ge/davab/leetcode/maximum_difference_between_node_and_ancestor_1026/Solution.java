package ge.davab.leetcode.maximum_difference_between_node_and_ancestor_1026;

import ge.davab.leetcode.util.TreeNode;

class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return maxAncestorDiff(root, root.val, root.val);
    }

    private int maxAncestorDiff(TreeNode root, int max, int min) {
        if (root == null) return 0;

        if (root.val > max) {
            max = root.val;
        } else if (root.val < min) {
            min = root.val;
        }

        int left = maxAncestorDiff(root.left, max, min);
        int right = maxAncestorDiff(root.right, max, min);
        int child = Math.max(left, right), cur = Math.abs(max - min);
        return Math.max(cur, child);
    }
}
