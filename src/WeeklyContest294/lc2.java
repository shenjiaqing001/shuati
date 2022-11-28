package WeeklyContest294;

import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/21/22
 */
public class lc2 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int res = 0;
        int n = capacity.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; ++i) {
            pq.add(capacity[i] - rocks[i]);
        }
        while (true) {
            if (pq.isEmpty()) break;
            if (additionalRocks < 0) break;
            if (pq.peek() > additionalRocks) break;
            additionalRocks -= pq.poll();
            res++;
        }
        return res;
    }
}
