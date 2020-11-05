import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/5
 */
public class lc310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] degree = new int[n];
        List<Integer>[] map = new ArrayList[n];
        for (int i = 0; i < n; ++i) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; ++i) {
            degree[edges[i][0]]++;
            degree[edges[i][1]]++;
            map[edges[i][0]].add(edges[i][1]);
            map[edges[i][1]].add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 1) q.add(i);
        }

        while (n > 2) {
            int size = q.size();
            n -= size;
            for (int i = 0; i < size; i++) {
                int now = q.poll();
                degree[now]--;
                List<Integer> nodeList = map[now];
                for (Integer next : nodeList) {
                    if (degree[next] == 0) continue;
                    degree[next]--;
                    if (degree[next] == 1) {
                        q.add(next);
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            res.add(q.poll());
        }
        return res;
    }
}
