package ge.davab.leetcode.amount_of_time_for_binary_tree_to_be_infected_2385;

import ge.davab.leetcode.util.TreeNode;

class Solution {

    private AdvTreeNode startNode;

    private static class AdvTreeNode {
        public AdvTreeNode parent;

        public AdvTreeNode left;

        public AdvTreeNode right;

        public int infectionTime = -1;

        public AdvTreeNode(AdvTreeNode parent) {
            this.parent = parent;
        }
    }

    private int timeAmount = -1;

    public int amountOfTime(TreeNode root, int start) {
        createAdvancedTreeNode(null, root, start);
        calcInfectionTime(startNode, 0);
        return timeAmount;
    }

    private void calcInfectionTime(AdvTreeNode startNode, int infectionTime) {
        timeAmount = Math.max(timeAmount, infectionTime);
        startNode.infectionTime = infectionTime;
        ++infectionTime;

        if (startNode.left != null && startNode.left.infectionTime == -1) {
            calcInfectionTime(startNode.left, infectionTime);
        }

        if (startNode.right != null && startNode.right.infectionTime == -1) {
            calcInfectionTime(startNode.right, infectionTime);
        }

        if (startNode.parent != null && startNode.parent.infectionTime == -1) {
            calcInfectionTime(startNode.parent, infectionTime);
        }
    }

    private AdvTreeNode createAdvancedTreeNode(AdvTreeNode parent, TreeNode node, int start) {
        if (node == null) return null;

        AdvTreeNode advTreeNode = new AdvTreeNode(parent);
        advTreeNode.left = createAdvancedTreeNode(advTreeNode, node.left, start);
        advTreeNode.right = createAdvancedTreeNode(advTreeNode, node.right, start);

        if (node.val == start) startNode = advTreeNode;

        return advTreeNode;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

    }
}
