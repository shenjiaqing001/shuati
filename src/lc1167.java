import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/25/20
 */
public class lc1167 {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < sticks.length; ++i) {
            pq.add(sticks[i]);
        }
        int res = 0;
        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            res += num1 + num2;
            pq.add(num1 + num2);
        }
        return res;
    }
}
