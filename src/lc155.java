import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/13/20
 */
public class lc155 {
    class MinStack {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MAX_VALUE;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            if (x <= min) {
                stack.add(min);
                min = Math.min(x, min);
            }
            stack.add(x);
        }

        public void pop() {
            if (min == stack.peek()) {
                stack.pop();
                min = stack.pop();
            } else {
                stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

}
