package WeeklyContest253;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/7
 */
public class lc1963 {
    public int minSwaps(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (deque.isEmpty()) deque.add(c);
            else {
                if (c == '[') deque.add(c);
                else {
                    if (deque.peekLast() == '[') deque.pollLast();
                    else deque.add(c);
                }
            }
        }
        return (deque.size() / 2 + 1) / 2;
    }

    public int minSwaps2(String s) {
        int left = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                left++;
            } else {
                if (left > 0) left--;
                else count++;
            }
        }
        return (count + 1) / 2;
    }
}
