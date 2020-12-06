package WeeklyContest217;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/6
 */
public class lc1675 {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int a : nums) {
            if (a % 2 == 1) a *= 2;
            pq.add(a);
            min = Math.min(min, a);
        }

        while (true) {
            int now = pq.poll();
            res = Math.min(res, now - min);
            if (now % 2 == 1) break;
            now /= 2;
            min = Math.min(now, min);
            pq.add(now);
        }
        return res;
    }
}
