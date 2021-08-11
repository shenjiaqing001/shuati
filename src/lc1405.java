import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/10
 */
public class lc1405 {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        Deque<int[]> deque = new ArrayDeque<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o2[1] - o1[1]));
        if (a != 0)
            pq.add(new int[]{0, a, 0});
        if (b != 0)
            pq.add(new int[]{1, b, 0});
        if (c != 0)
            pq.add(new int[]{2, c, 0});

        while (true) {
            if (!deque.isEmpty() && deque.peekFirst()[2] == sb.length()) {
                pq.add(deque.pollFirst());
            }
            if (pq.isEmpty()) break;
            int[] now = pq.poll();
            now[1]--;
            if (now[1] > 0 && sb.length() > 0 &&
                    sb.charAt(sb.length() - 1) == (char) (now[0] + 'a')) {
                now[2] = sb.length() + 2;
                deque.add(now);
            } else {
                if (now[1] > 0)
                    pq.add(now);
            }
            sb.append((char) (now[0] + 'a'));
        }

        return sb.toString();
    }
}
