
public class LinkedListCycle_II {

    class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {

        public ListNode detectCycle(ListNode head) {
            int length = lengthOfCycle(head);
            if (length == 0) {
                return null;
            }
            ListNode f = head;
            ListNode s = head;
            while (length > 0) {
                s = s.next;
                length--;
            }
            while (f != s) {
                f = f.next;
                s = s.next;
            }
            return s;
        }

        public int lengthOfCycle(ListNode head) {
            int length = 0;
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {

                    ListNode temp = slow;
                    do {
                        temp = temp.next;
                        length++;
                    } while (temp != slow);
                    return length;
                }
            }
            return 0;
        }
    }
}
