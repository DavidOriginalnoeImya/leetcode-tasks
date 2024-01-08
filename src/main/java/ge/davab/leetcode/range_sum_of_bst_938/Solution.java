package ge.davab.leetcode.range_sum_of_bst_938;

import ge.davab.leetcode.util.TreeNode;

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;

        if (root.left != null && root.val != low)
            sum += rangeSumBST(root.left, low, high);

        if (root.right != null && root.val != high)
            sum += rangeSumBST(root.right, low, high);

        if (root.val >= low && root.val <= high)
            sum += root.val;

        return sum;
    }
}
