import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/7
 */
public class lc1209 {
    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast().c == c) {
                stack.peekLast().v += 1;
            } else {
                stack.addLast(new Pair(c, 1));
            }
            if (stack.peekLast().v == k) {
                stack.pollLast();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            Pair p = stack.pollFirst();
            for (int i = 0; i < p.v; i++) {
                sb.append(p.c);
            }
        }
        return sb.toString();
    }

    public class Pair {
        char c;
        int v;

        Pair(char c, int v) {
            this.c = c;
            this.v = v;
        }
    }
}
