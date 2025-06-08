/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public int length(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = length(head);

        // If removing the only node
        if (len == 1 && n == 1) {
            return null;
        }

        // If removing the first node
        if (n == len) {
            return head.next;
        }

        // Traverse to the (len - n - 1)th node
        ListNode temp = head;
        for (int i = 1; i < len - n; i++) {
            temp = temp.next;
        }

        // Remove nth node from end
        temp.next = temp.next.next;

        return head;
    }
}
