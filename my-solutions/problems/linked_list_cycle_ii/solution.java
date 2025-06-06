/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        


        ListNode start  = head;
        ListNode temp = head;
        int length = lengthOfCycle(head);
        if(length==0 || head == null || head.next == null) return null;
        while(length>0){
            start = start.next;
            length--;
        }
        while(start != temp){
            start = start.next;
            temp = temp.next;
        }
        return start;
        
    }
    public int lengthOfCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        int length = 0;

        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                do{
                    slow = slow.next;
                    length ++;
                }
                while(fast != slow);
                return length;
            }
        }
        return 0;
    }
}