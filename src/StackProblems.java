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
    //next greatest element ||
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[n-1]);
        for(int i =2*n-1; i>=0; i--){
            {
                int index = i%n;
                while( !stack.empty() && stack.peek() <=nums[index]){
                    stack.pop();
                }
                if(i<n){
                    if(stack.empty()){
                        res[index] = -1;
                    } else {
                        res[index] = stack.peek();
                    }
                }
                stack.push(nums[index]);
            }
        }
        return res;
    }
    //Daily Temperatures
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i>=0;i--){
            while(!stack.empty() && temperatures[stack.peek()] <=temperatures[i]){
                stack.pop();
            }
            if(stack.empty()){
                res[i] = 0;
            }
            else{
                res[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return res;
    }
}
