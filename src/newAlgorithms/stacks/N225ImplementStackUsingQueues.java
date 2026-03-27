package newAlgorithms.stacks;

import java.util.LinkedList;
import java.util.Queue;

public class N225ImplementStackUsingQueues {
    private Queue<Integer> q;

    public N225ImplementStackUsingQueues() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
