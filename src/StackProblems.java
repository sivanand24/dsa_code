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
    //baseball game
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String op : operations){
            if(op.equals("+")){
                int sum = stack.get(stack.size() - 1) + stack.get(stack.size() - 2);
                stack.push(sum);
            } else if (op.equals("D")){
                stack.push(stack.peek() * 2);
            } else if(op.equals("C")){
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }

        }
        int sum = 0;
        for(int score : stack){
            sum = sum + score;
        }
        return sum;

    }
    //remove adjacent duplicate element in String
    public String removeDuplicates2(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<n; i++){
            if(st.empty()){
                st.push(s.charAt(i));
                continue;
            }
            if(st.peek() == s.charAt(i)){
                st.pop();
                continue;
            }
            st.push(s.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        while(!st.empty()){
            res.append(st.peek());
            st.pop();
        }
        return res.reverse().toString();
    }
}
