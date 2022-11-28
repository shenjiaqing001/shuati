package WeeklyContest312;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/24/22
 */
public class lc4 {
    public class UnionFind {
        int[] p;

        public UnionFind(int n) {
            p = new int[n];
            for (int i = 0; i < n; ++i) p[i] = i;
        }

        public int get(int x) {
            return p[x] == x ? x : (p[x] = get(p[x]));
        }

        public void union(int x, int y) {
            int a = get(x);
            int b = get(y);
            if (p[a] < p[b]) p[b] = p[a];
            else p[a] = p[b];
        }
    }

    UnionFind uf;
    Map<Integer, Set<Integer>> map = new HashMap<>();
    TreeMap<Integer, Set<Integer>> treeMap = new TreeMap<>();

    public int solve(int[] vals) {
        int min = treeMap.firstKey();
        Set<Integer> set = treeMap.pollFirstEntry().getValue();
        int res = 0;
        for (int node : set) {
            if (!map.containsKey(node)) continue;
            for (int neighbor : map.get(node)) {
                if (vals[neighbor] <= min) {
                    uf.union(neighbor, node);
                }
            }
        }
        Map<Integer, Integer> tmp = new HashMap<>();
        for (int node : set) {
            int root = uf.get(node);
            tmp.put(root, tmp.getOrDefault(root, 0) + 1);
        }
        for (int key : tmp.keySet()) {
            int value = tmp.get(key);
            res += value;
            if (value > 1) {
                res += value * (value - 1) / 2;
            }
        }
        return res;
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int res = 0;
        uf = new UnionFind(vals.length);
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            map.putIfAbsent(a, new HashSet<>());
            map.putIfAbsent(b, new HashSet<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        for (int i = 0; i < vals.length; ++i) {
            treeMap.putIfAbsent(vals[i], new HashSet<>());
            treeMap.get(vals[i]).add(i);
        }
        while (!treeMap.isEmpty()) {
            res += solve(vals);
        }
        return res;
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
        System.out.println(test.numberOfGoodPaths(new int[]{1, 3, 2, 1, 3},
                new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}}));
    }
}
