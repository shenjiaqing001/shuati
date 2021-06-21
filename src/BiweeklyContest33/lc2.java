package BiweeklyContest33;

//import javafx.util.Pair;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/22/20
 */
public class lc2 {


    public List<Integer> findSmallestSetOfVertices(int n,
                                                   List<List<Integer>> edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[n];
        int[] in = new int[n];
        List<Integer> res = new ArrayList<>();
        for (List<Integer> edge : edges) {
            int from = edge.get(0);
            int to = edge.get(1);
            in[to]++;
            graph[from].add(to);
        }

        for (int i = 0; i < n; ++i) {
            if (in[i] == 0) {
                dfs(i, visited, graph);
                res.add(i);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i, visited, graph);
                res.add(i);
            }
        }
        return res;
    }

    public void dfs(int from, boolean[] visited, List<Integer>[] graph) {
        if (visited[from]) return;
        visited[from] = true;
        for (Integer next : graph[from]) {
            if (!visited[next])
                dfs(next, visited, graph);
        }
    }
}
