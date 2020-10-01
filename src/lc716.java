import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/26
 */
public class lc716 {
    class MaxStack {
        Stack<Integer> stack = new Stack<>();
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        public MaxStack() {

        }

        public void push(int x) {
            stack.add(x);
            treeMap.put(x, treeMap.getOrDefault(x, 0) + 1);
        }

        public int pop() {
            int num = stack.pop();
            treeMap.put(num, treeMap.get(num) - 1);
            if (treeMap.get(num) == 0) treeMap.remove(num);
            return num;
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return treeMap.lastKey();
        }

        public int popMax() {
            int num = treeMap.lastKey();
            if (treeMap.get(num) == 1)
                treeMap.remove(num);
            else
                treeMap.put(num, treeMap.get(num) - 1);

            Stack<Integer> tmp = new Stack<>();
            while (stack.peek() != num) {
                tmp.add(stack.pop());
            }
            stack.pop();
            while (!tmp.empty()) stack.add(tmp.pop());
            return num;
        }
    }
}
