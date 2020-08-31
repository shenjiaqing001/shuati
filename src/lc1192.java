import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/20/20
 */
public class lc1192 {
    List<List<Integer>> res = new LinkedList<>();
    boolean[] visit;
    List<Integer>[] adjList;
    int[] dfn;
    int[] val;
    int time = 1;

    public List<List<Integer>> criticalConnections(int n,
                                                   List<List<Integer>> connections) {
        visit = new boolean[n];
        adjList = new List[n];
        dfn = new int[n];
        val = new int[n];

        for (int i = 0; i < n; ++i) {
            adjList[i] = new LinkedList<>();
        }

        for (int i = 0; i < connections.size(); ++i) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adjList[u].add(v);
            adjList[v].add(u);
        }

        for (int i = 0; i < n; ++i) {
            if (!visit[i])
                dfs(i, -1);
        }

        return res;
    }

    public void dfs(int node, int parent) {
        dfn[node] = time;
        val[node] = time;
        time++;
        visit[node] = true;

        for (int next : adjList[node]) {
            if (next == parent) continue;
            if (!visit[next]) {
                dfs(next, node);
                val[node] = Math.min(val[node], val[next]);
                if (dfn[node] < val[next]) {
                    res.add(Arrays.asList(node, next));
                }
            } else {
                val[node] = Math.min(dfn[next], val[node]);
            }
        }
    }
}
