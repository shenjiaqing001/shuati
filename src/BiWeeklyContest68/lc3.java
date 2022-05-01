package BiWeeklyContest68;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/25/21
 */
public class lc3 {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) return false;
        char[] c = s.toCharArray();
        char[] l = locked.toCharArray();

        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> empty = new ArrayDeque<>();
        for (int i = 0; i < c.length; ++i) {
            if (l[i] == '1') {
                if (c[i] == '(') {
                    deque.add(i);
                } else {
                    if (!deque.isEmpty() && c[deque.getLast()] == '(') deque.pollLast();
                    else if (!empty.isEmpty()) empty.pollLast();
                    else return false;
                }
            } else {
                empty.add(i);
            }
        }
        while (!deque.isEmpty()) {
            l[deque.pollFirst()] = '2';
        }
        while (!empty.isEmpty()) {
            l[empty.pollFirst()] = '3';
        }
        int count = 0;
        for (int i = 0; i < c.length; ++i) {
            if (l[i] == '2') count++;
            else if (l[i] == '3') {
                if (count > 0) count--;
            }
        }
        if (count > 0) return false;
        return true;
    }
}
