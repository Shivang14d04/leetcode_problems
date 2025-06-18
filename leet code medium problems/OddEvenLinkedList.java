
public class OddEvenLinkedList {

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {

        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode odd = head;
            ListNode even = head.next;
            ListNode evenHead = even;
            while (even != null && even.next != null) {
                odd.next = odd.next.next;
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;

        }

        public ListNode oddEvenList_Solution2(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode odd = new ListNode(0);
            ListNode odd_ptr = odd;
            ListNode even = new ListNode(0);
            ListNode even_ptr = even;
            int idx = 1;
            while (head != null) {
                if (idx % 2 == 0) {
                    even_ptr.next = head;
                    even_ptr = even_ptr.next;
                } else {
                    odd_ptr.next = head;
                    odd_ptr = odd_ptr.next;
                }
                head = head.next;
                idx++;
            }
            even_ptr.next = null;
            odd_ptr.next = even.next;
            return odd.next;
        }
    }
}
