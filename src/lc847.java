import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/26/22
 */
public class lc847 {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            q.add(new int[]{i, 1 << i});
        }
        Set<String> set = new HashSet<>();
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int[] now = q.poll();
                if (now[1] == (1 << n) - 1) return step;
                for (int next : graph[now[0]]) {
                    if (set.contains(next + ":" + (now[1] | (1 << next)))) continue;
                    set.add(next + ":" + (now[1] | (1 << next)));
                    q.add(new int[]{next, now[1] | (1 << next)});
                }
            }
            step++;
        }
        return -1;
    }
}
