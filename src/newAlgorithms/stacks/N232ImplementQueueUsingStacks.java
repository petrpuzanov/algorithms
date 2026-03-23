package newAlgorithms.stacks;

import java.util.Stack;

public class N232ImplementQueueUsingStacks {
    private Stack<Integer> input;
    private Stack<Integer> output;

    N232ImplementQueueUsingStacks() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        replace();
        return output.pop();
    }

    public int peek() {
        replace();
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    private void replace() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }
}
