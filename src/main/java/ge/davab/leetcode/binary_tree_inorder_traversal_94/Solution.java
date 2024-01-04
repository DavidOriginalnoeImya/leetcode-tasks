package ge.davab.leetcode.binary_tree_inorder_traversal_94;

import ge.davab.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return List.of();

        List<Integer> values = new LinkedList<>(inorderTraversal(root.left));
        values.add(root.val);
        values.addAll(inorderTraversal(root.right));
        return values;
    }
}
