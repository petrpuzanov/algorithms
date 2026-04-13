package newAlgorithms.stacks;

import java.util.Stack;
//todo
public class N856ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0); // маркер начала
            } else {
                int val = 0;

                while (stack.peek() != 0) {
                    val += stack.pop();
                }

                stack.pop(); // убираем 0

                if (val == 0) {
                    stack.push(1); // "()"
                } else {
                    stack.push(2 * val); // "(A)"
                }
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
