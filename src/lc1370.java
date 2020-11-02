import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/2
 */
public class lc1370 {
    public String sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        Stack<Character> first = new Stack<>();
        Stack<Character> second = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = c.length - 1; i >= 0; --i) first.add(c[i]);

        while (!first.isEmpty()) {
            char start = 'a' - 1;
            while (!first.isEmpty()) {
                char tmp = first.pop();
                if (tmp > start) {
                    sb.append(tmp);
                    start = tmp;
                } else second.add(tmp);
            }
            start = 'z' + 1;
            while (!second.isEmpty()) {
                char tmp = second.pop();
                if (tmp < start) {
                    sb.append(tmp);
                    start = tmp;
                } else first.add(tmp);
            }
        }
        return sb.toString();
    }
}
