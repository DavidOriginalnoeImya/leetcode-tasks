package ge.davab.leetcode.reverse_nodes_in_k_group_25;

import ge.davab.leetcode.util.ListNode;

class Solution {
    private ListNode[] listNodes;

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode headCopy = head;
        listNodes = new ListNode[k];

        while (true) {
            getNextKGroup(headCopy, k);

            if (listNodes != null) {
                headCopy = listNodes[k - 1].next;
                for (int index = 0; index < k / 2; ++index) {
                    int tmp = listNodes[index].val;
                    listNodes[index].val = listNodes[k - 1 - index].val;
                    listNodes[k - 1 - index].val = tmp;
                }
            }
            else break;
        }

        return head;
    }

    private void getNextKGroup(ListNode head, int k) {
        int count = 0;

        while (head != null) {
            listNodes[count] = head;
            head = head.next;

            if (count == k - 1) return;
            ++count;
        }

        listNodes = null;
    }

}
