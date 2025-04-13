
import java.util.Stack;

public class DesignFrontMiddleBackQueue {

    Stack<Integer> stack1 = new Stack<>(); // Main stack
    Stack<Integer> stack2 = new Stack<>(); // Helper stack

    public DesignFrontMiddleBackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void pushFront(int val) {
        stack1.push(val);
    }

    public void pushMiddle(int val) {
        int n = stack1.size() / 2;

        // Move top half to stack2
        for (int i = 0; i < n; i++) {
            stack2.push(stack1.pop());
        }

        // Insert middle element
        stack1.push(val);

        // Move elements back
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public void pushBack(int val) {
        // Reverse entire stack into stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack2.push(val); // Add to back

        // Reverse back to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int popFront() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.pop();
    }

    public int popMiddle() {
        if (stack1.isEmpty()) {
            return -1;
        }

        int n = (stack1.size() - 1) / 2;

        // Move top half to stack2
        for (int i = 0; i < n; i++) {
            stack2.push(stack1.pop());
        }

        int val = stack1.pop(); // Middle element

        // Move elements back
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return val;
    }

    public int popBack() {
        if (stack1.isEmpty()) {
            return -1;
        }

        // Reverse stack1 into stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int val = stack2.pop(); // Back element

        // Restore
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return val;
    }
}
