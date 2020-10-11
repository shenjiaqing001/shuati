import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/9
 */
public class lc1245 {
    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            map.putIfAbsent(edges[i][0], new ArrayList<>());
            map.putIfAbsent(edges[i][1], new ArrayList<>());
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        int start = edges[0][0];
        Map<Integer, Integer> tmp = new HashMap<>();
        tmp.put(start, 0);
        dfs(map, tmp, start, start);
        int max = 0;
        for (Integer num : tmp.keySet()) {
            if (max < tmp.get(num)) {
                max = tmp.get(num);
                start = num;
            }
        }
        tmp = new HashMap<>();
        tmp.put(start, 0);
        dfs(map, tmp, start, start);
        max = 0;
        for (Integer num : tmp.keySet()) {
            if (max < tmp.get(num)) {
                max = tmp.get(num);
            }
        }
        return max;
    }

    public void dfs(Map<Integer, List<Integer>> map, Map<Integer, Integer> tmp, int now, int last) {
        List<Integer> canGO = map.get(now);
        for (Integer next : canGO) {
            if (next == last) continue;
            tmp.put(next, tmp.get(now) + 1);
            dfs(map, tmp, next, now);
        }
    }

    class Solution {
        int diameter = 0;
        public int treeDiameter(int[][] edges) {
            int n = edges.length + 1;
            List<Integer>[] graph = new List[n];
            for (int i = 0; i < n; ++i) graph[i] = new LinkedList<>();
            for (int[] e : edges) {
                graph[e[0]].add(e[1]);
                graph[e[1]].add(e[0]);
            }
            diameter = 0;
            depth(0, -1, graph);
            return diameter;
        }
        // Depth of the tree is the number of nodes along the longest path from the root node down to the farthest leaf node.
        int depth(int root, int parent, List<Integer>[] graph) {
            int maxDepth1st = 0, maxDepth2nd = 0;
            for (int child : graph[root]) {
                if (child == parent) continue; // Only one way from root node to child node, don't allow child node go to root node again!
                int childDepth = depth(child, root, graph);
                if (childDepth > maxDepth1st) {
                    maxDepth2nd = maxDepth1st;
                    maxDepth1st = childDepth;
                } else if (childDepth > maxDepth2nd) {
                    maxDepth2nd = childDepth;
                }
            }
            int longestPathThroughRoot = maxDepth1st + maxDepth2nd + 1; // the number of nodes in the longest path
            diameter = Math.max(diameter, longestPathThroughRoot - 1); // diameter = number of edges = number of nodes - 1
            return maxDepth1st + 1;
        }
    }
}
