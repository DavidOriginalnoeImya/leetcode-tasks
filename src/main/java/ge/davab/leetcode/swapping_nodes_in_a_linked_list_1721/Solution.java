package ge.davab.leetcode.swapping_nodes_in_a_linked_list_1721;

import ge.davab.leetcode.util.ListNode;

class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int listSize = 0;
        ListNode headCopy = head, begNode = null;

        while (headCopy != null) {
            ++listSize;
            if (k == listSize) begNode = headCopy;
            headCopy = headCopy.next;
        }

        int endNodePos = listSize - k + 1;
        headCopy = k <= endNodePos ? begNode : head;
        int curIndex = k <= endNodePos ? k : 1;

        while (curIndex < endNodePos) {
            ++curIndex;
            headCopy = headCopy.next;
        }

        int tmp = headCopy.val;
        headCopy.val = begNode.val;
        begNode.val = tmp;

        return head;
    }
}
