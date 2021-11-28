import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/28/21
 */
public class lc797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < graph.length; ++i) {
            map.put(i, new ArrayList<>());
            for (int child : graph[i]) {
                map.get(i).add(child);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> route = new LinkedList<>();
        route.add(0);
        dfs(map, res, route, 0, graph.length - 1);
        return res;
    }

    public void dfs(Map<Integer, List<Integer>> map, List<List<Integer>> res, List<Integer> route,
                    int now, int end) {
        if (now == end) {
            res.add(new ArrayList<>(route));
            return;
        }
        if (map.containsKey(now)) {
            for (int child : map.get(now)) {
                route.add(child);
                dfs(map, res, route, child, end);
                route.remove(route.size() - 1);
            }
        }
    }

}
