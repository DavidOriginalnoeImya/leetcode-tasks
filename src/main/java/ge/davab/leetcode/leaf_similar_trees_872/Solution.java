package ge.davab.leetcode.leaf_similar_trees_872;

import ge.davab.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private final Queue<Integer> leafValues = new LinkedList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        fillLeafQueue(root1);
        return checkLeafQueue(root2) && leafValues.isEmpty();
    }

    public void fillLeafQueue(TreeNode root) {
        if (root.left == null && root.right == null) leafValues.add(root.val);
        if (root.left != null) fillLeafQueue(root.left);
        if (root.right != null) fillLeafQueue(root.right);
    }

    public boolean checkLeafQueue(TreeNode root) {
        if (root.left == null && root.right == null)
            return !leafValues.isEmpty() && leafValues.poll() == root.val;

        if (root.left != null) {
            if (!checkLeafQueue(root.left)) return false;
        }

        if (root.right != null) {
            return checkLeafQueue(root.right);
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode root1 = TreeNode.create(new Integer[]{3,5,1,6,2,9,8,null,null,7,4});
        System.out.println(root1.toList());
    }
}
