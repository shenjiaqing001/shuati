package OnlineAssessment.LCCUP;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/14/20
 */
public class lcp20 {
    public int busRapidTransit(int target, int inc, int dec, int[] jump, int[] cost) {
        Map<Long, Long> map = new HashMap<>();
        long zero = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                long length1 = (target - o1[0]) * inc + o1[1];
                long length2 = (target - o2[0]) * inc + o2[1];
                return (int) (length1 - length2);
            }
        });

        pq.add(new long[]{zero, zero});

        while (true) {
            long[] now = pq.poll();
            if (now[0] == target) return (int) now[1];
            if (map.containsKey(now[0])) continue;
            map.put(now[0], now[1]);
            if (now[0] > target) {
                pq.add(new long[]{target, now[1] + (now[0] - target) * dec});
            }

            if (now[0] - 1 >= 0 && !map.containsKey(now[0] - 1)) {
                if (!map.containsKey(now[0] - 1))
                    pq.add(new long[]{now[0] - 1, (now[1] + dec) % 1000000007});
            }
            if (now[0] < target && !map.containsKey(now[0] + 1)) {
                if (!map.containsKey(now[0] + 1))
                    pq.add(new long[]{now[0] + 1, (now[1] + inc) % 1000000007});
            }

            if (now[0] < target)
                for (int i = 0; i < jump.length; ++i) {
                    long next = now[0] * jump[i];
                    if (next > target && next - target > jump[i]) continue;
                    if (map.containsKey(next)) continue;
                    if (map.get(now[0]) + cost[i] >= next * inc) continue;
                    if ((next - now[0]) * inc <= cost[i]) continue;
                    pq.add(new long[]{next, map.get(now[0]) + cost[i]});
                }
        }
    }
}
