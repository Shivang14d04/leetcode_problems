
import java.util.Scanner;

class ListNode {

    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class MiddleOfLinkedList {

    public static ListNode findMiddle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode createLinkedList(int[] values) {
        if (values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the linked list: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("The linked list is empty.");
            scanner.close();
            return;
        }

        int[] values = new int[n];
        System.out.println("Enter the elements of the linked list:");
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        ListNode head = createLinkedList(values);
        ListNode middle = findMiddle(head);

        if (middle != null) {
            System.out.println("The middle node value is: " + middle.value);
        } else {
            System.out.println("The linked list is empty.");
        }

        scanner.close();
    }
}
