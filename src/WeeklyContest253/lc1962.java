package WeeklyContest253;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/7
 */
public class lc1962 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int pile : piles) pq.add(pile);
        for (int i = 0; i < k; ++i) {
            int num = pq.poll();
            pq.add((num + 1) / 2);
        }

        int sum = 0;
        while (!pq.isEmpty()) sum += pq.poll();
        return sum;
    }
}
