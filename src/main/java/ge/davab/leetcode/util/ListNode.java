package ge.davab.leetcode.util;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode getList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]), cur = head;

        for (int index = 1; index < arr.length; ++index) {
            cur.next = new ListNode(arr[index], null);
            cur = cur.next;
        }

        return head;
    }

    public static void printList(ListNode listNode) {
        ListNode lst = listNode;

        while (lst != null) {
            System.out.print(lst.val + " ");
            lst = lst.next;
        }
    }
}


