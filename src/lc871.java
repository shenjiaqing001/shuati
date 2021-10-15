import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/14
 */
public class lc871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) return 0;
        // index, fuel, time, pos
        int n = stations.length;
        int[][] dp = new int[n + 5][n + 5];
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(((o1, o2) -> (
                        o1[2] == o2[2] ? (o2[3] + o2[1]) - (o1[1] + o1[3]) : o1[2] - o2[2])));
        pq.add(new int[]{-1, startFuel, 0, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int next = now[0] + 1;
            while (next < n && stations[next][0] - now[3] <= now[1]) {
                int left = now[1] - (stations[next][0] - now[3]);
                if (dp[next][now[2]] >= left) {
                    next++;
                    continue;
                }
                dp[next][now[2]] = left;
                if (left + stations[next][1] >= target - stations[next][0]) return now[2] + 1;
                pq.add(new int[]{next, left + stations[next][1], now[2] + 1, stations[next][0]});
                next++;
            }
        }
        return -1;
    }

    public int minRefuelStops2(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int res = -1;
        int sum = 0;
        int index = 0;
        pq.add(startFuel);
        while (!pq.isEmpty()) {
            sum += pq.poll();
            res++;
            if (sum >= target) return res;
            while (index < stations.length && stations[index][0] <= sum) {
                pq.add(stations[index][1]);
                index++;
            }
        }
        return -1;
    }

}
