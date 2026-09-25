import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StackProblems {
    //remove adjacent duplicate element in string
    public String removeDuplicates(String s) {
        StringBuilder stk = new StringBuilder();
        for (char c : s.toCharArray()) {
            int len = stk.length();
            if (len > 0 && stk.charAt(len - 1) == c) {
                stk.deleteCharAt(len - 1);
            } else {
                stk.append(c);
            }
        }
        return stk.toString();
    }

    //valid parenthesis problem
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;

            }

        }
        return stack.isEmpty();
    }

    //min stack problem
    class MinStack {
        private Deque<Integer> stack;
        private Deque<Integer> minStack;

        public MinStack() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();

        }

        public void push(int value) {
            stack.push(value);
            minStack.push(minStack.isEmpty() ? value : Math.min(value, minStack.peek()));

        }

        public void pop() {
            stack.pop();
            minStack.pop();

        }

        public int top() {
            return stack.peek();

        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
