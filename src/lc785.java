/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/17/20
 */
public class lc785 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] p = new int[n];

        for (int i = 0; i < n; ++i) {
            if (p[i] == 0) {
                p[i] = 1;
                if (dfs(i, 1, graph, p) == false) return false;
            }
        }
        return true;
    }

    public boolean dfs(int n, int depth, int[][] graph, int[] p) {
        for (int next : graph[n]) {
            if (p[next] != 0) {
                if ((p[next] - depth) % 2 == 0) return false;
            } else {
                p[next] = depth + 1;
                if (dfs(next, depth + 1, graph, p) == false) return false;
            }
        }
        return true;
    }
}
