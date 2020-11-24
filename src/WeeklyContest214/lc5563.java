package WeeklyContest214;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/8
 */
public class lc5563 {
    public int maxProfit(int[] inventory, int orders) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < inventory.length; ++i) {
            if (map.containsKey(inventory[i])) {
                map.put(inventory[i], map.get(inventory[i]) + 1);
            } else {
                map.put(inventory[i], 1);
                pq.add(inventory[i]);
            }
        }
        long res = 0;
        while (orders > 0) {
            int most = pq.poll();
            long num = 0;
            int nextMost = 0;
            if (pq.isEmpty()) {
                num = map.get((int)most) * most;
            } else {
                nextMost = pq.peek();
                num = (most - nextMost) * map.get(most);
            }

            if (num <= orders) {
                res +=  (nextMost + most + (long)1) * map.get(most) * (most - nextMost) / 2;
                res %= 1000000007;
                orders -= num;
                if (orders != 0) {
                    map.put(nextMost, map.get(nextMost) + map.get(most));
                }
            } else {
                num = map.get(most);
                long devide = orders / num;
                long remain = orders % num;

                res += num * (most + most - devide + 1) * devide / 2;
                res += (most - devide) * remain;
                res %= 1000000007;
                orders = 0;
                break;
            }
        }

        return (int) res;
    }
}
