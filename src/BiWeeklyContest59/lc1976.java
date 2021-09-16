package BiWeeklyContest59;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/21
 */
public class lc1976 {
    public int countPaths(int n, int[][] roads) {
        if (n == 1) return 1;

        long[] visitTime = new long[n + 5];
        long[] count = new long[n + 5];
        visitTime[0] = 0;
        for (int i = 0; i < n; ++i) visitTime[i] = -1;
        count[0] = 0;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] road : roads) {
            map.putIfAbsent(road[0], new LinkedList<>());
            map.putIfAbsent(road[1], new LinkedList<>());
            map.get(road[0]).add(new int[]{road[1], road[2]});
            map.get(road[1]).add(new int[]{road[0], road[2]});
        }
        count[n] = 1;
        // 0 index, 1 from, 2 time
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[2]));
        pq.add(new long[]{0, n, 0});
        while (!pq.isEmpty()) {
            long[] now = pq.poll();
            if (visitTime[(int) now[0]] == -1) {
                visitTime[(int) now[0]] = now[2];
                count[(int) now[0]] += count[(int) now[1]];
                count[(int) now[0]] %= 1_000_000_007;
                for (int[] road : map.get((int) now[0])) {
                    long time = now[2] + (long) road[1];
                    if (visitTime[road[0]] == -1 || visitTime[road[0]] == time) {
                        pq.add(new long[]{road[0], now[0], time});
                    }
                }
            } else if (visitTime[(int) now[0]] == now[2]) {
                count[(int) now[0]] += count[(int) now[1]];
                count[(int) now[0]] %= 1_000_000_007;
            }
        }
        return (int) count[n - 1];
    }
}
