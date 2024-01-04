package ge.davab.leetcode.construct_string_from_binary_tree_606;

import ge.davab.leetcode.util.TreeNode;

class Solution {
    public String tree2str(TreeNode root) {
        if (root.left == null && root.right == null)
            return String.valueOf(root.val);

        String left = "()";

        if (root.left != null) {
            left = "(" + tree2str(root.left) + ")";
        }

        String right = "";

        if (root.right != null) {
            right = "(" + tree2str(root.right) + ")";
        }

        return root.val + left + right;
    }
}
