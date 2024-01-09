package ge.davab.leetcode.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode create(Integer[] values) {
        if (values == null || values.length == 0)
            throw new IllegalArgumentException("Values array must contain at least 1 element");

        TreeNode root = new TreeNode(values[0]);

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
//{3,5,1,6,2,9,8,null,null,7,4}
        for (int i = 1; i < values.length; ++i) {
            TreeNode node = values[i] != null ? new TreeNode(values[i]) : null;

            if (i % 2 != 0) nodes.peek().left = node;
            else nodes.poll().right = node;

            if (node != null) nodes.add(node);
        }

        return root;
    }

    public List<Integer> toList() {
        List<Integer> values = new LinkedList<>();
        fillList(this, values);
        return values;
    }

    private static void fillList(TreeNode tree, List<Integer> list) {
        list.add(tree.val);
        if (tree.left != null) fillList(tree.left, list);
        if (tree.right != null) fillList(tree.right, list);
    }
}
