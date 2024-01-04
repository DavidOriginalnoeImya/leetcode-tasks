package ge.davab.leetcode.add_two_numbers_2;

import ge.davab.leetcode.util.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = null, prev = null, beg = null;

        int carry = 0;

        boolean isBeg = true;

        while (l1 != null && l2 != null) {
            prev = cur;
            cur = new ListNode((l1.val + l2.val + carry) % 10, null);
            if (isBeg) {
                beg = cur; isBeg = false;
            }
            carry = (l1.val + l2.val + carry) / 10;
            if (prev != null) prev.next = cur;
            if (l1.next == null && l2.next == null) break;
            if (l1.next == null) l1.next = new ListNode(0, null);
            if (l2.next == null) l2.next = new ListNode(0, null);
            l1 = l1.next; l2 = l2.next;
        }

        if (carry > 0) cur.next = new ListNode(1, null);

        return beg;
    }
}
