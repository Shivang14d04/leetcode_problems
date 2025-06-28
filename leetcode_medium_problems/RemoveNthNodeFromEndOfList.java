public class RemoveNthNodeFromEndOfList {
    
    public int lengthOfList(ListNode head){
        ListNode current = head;
        int length = 0;
        while(current.next != null){
            current = current.next;
            length++;
        }
        return length;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = lengthOfList(head);
        if(length == 1 && n == 1){return null;}
        if(length == n){return head.next;}
        ListNode current = head;
        for(int i = 1 ; i< length-n;i++){
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }
    
}
