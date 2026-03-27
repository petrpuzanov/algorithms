package newAlgorithms.stacks;

import java.util.Stack;

//https://leetcode.com/problems/valid-parentheses/description/
public class N20ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                char top = stack.pop();
                if (stack.isEmpty()
                        || (ch == ')' && top != '(')
                        || (ch == ']' && top != '[')
                        || (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        N20ValidParentheses.isValid("()[]{}");

    }
}
