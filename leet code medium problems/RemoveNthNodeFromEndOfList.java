public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Handle edge case where list is empty
        if (head == null) return null;
        
        // Create a dummy node to handle edge cases (like removing first node)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode first = dummy;
        ListNode second = dummy;
        
        // Advance first pointer by n+1 steps
        for (int i = 0; i <= n; i++) {
            first = first.next;
            // Handle case where n is larger than list length
            if (i < n && first == null) return head;
        }
        
        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        // Remove the nth node from end
        second.next = second.next.next;
        
        return dummy.next;
    }
}
