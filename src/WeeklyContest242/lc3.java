package WeeklyContest242;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/22
 */
public class lc3 {
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] c = s.toCharArray();
        int n = s.length();
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        for (int i = 1; i < n; ++i) {
            while (!q.isEmpty() && q.peek() < i - maxJump) q.poll();

            if (c[i] == '0' && !q.isEmpty() && i - q.peek() >= minJump && i - q.peek() <= maxJump) {
                q.add(i);
                if (i == n - 1) return true;
            }
            if (q.isEmpty()) return false;
        }
        return false;
    }
}
