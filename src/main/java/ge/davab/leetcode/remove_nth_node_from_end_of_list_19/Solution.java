package ge.davab.leetcode.remove_nth_node_from_end_of_list_19;

import ge.davab.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head != null) {
            List<ListNode> list = new ArrayList<>();

            while (head != null) {
                list.add(head);
                head = head.next;
            }

            int delElPos = list.size() - n;

            if (delElPos <= 0) {
                head = list.get(0).next;
            }
            else {
                list.get(delElPos - 1).next = list.get(delElPos).next;
                head = list.get(0);
            }
        }

        return head;
    }
}
