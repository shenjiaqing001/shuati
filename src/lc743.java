import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/25
 */
public class lc743 {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            map.putIfAbsent(time[0], new ArrayList<>());
            map.get(time[0]).add(new int[]{time[1], time[2]});
        }
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        q.add(new int[]{k, 0});
        int max = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (visited[now[0]]) continue;
            visited[now[0]] = true;
            max = Math.max(max, now[1]);

            if (map.containsKey(now[0])) {
                for (int[] next : map.get(now[0])) {
                    if (!visited[next[0]]) {
                        q.add(new int[]{next[0], now[1] + next[1]});
                    }
                }
            }
        }
        for (int i = 1; i <= n; ++i) {
            if (!visited[i]) return -1;
        }
        return max;
    }


}
