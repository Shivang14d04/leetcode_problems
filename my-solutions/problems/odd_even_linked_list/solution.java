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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode even_ptr = even;
        ListNode odd_ptr = odd;
        int index = 1;
        while(head != null){
            if(index%2 ==0){
                even_ptr.next = head;
                even_ptr = even_ptr.next;
            }
            else{
                odd_ptr.next = head;

                odd_ptr = odd_ptr.next;
            }
            head = head.next;
            index++;
        }
        even_ptr.next = null;
        odd_ptr.next = even.next;
        return odd.next;
    }
}