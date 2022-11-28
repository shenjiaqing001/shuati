package WeeklyContest299;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 6/25/22
 */
public class lc4 {
    int[] level = new int[1001];
    int[] or = new int[1001];
    Set<Integer>[] childrenVal = new Set[1001];
    Set<Integer> set = new HashSet<>();

    public void dfs(int now, Map<Integer, List<Integer>> map, int[] nums) {
        int tmp = 0;
        for (int child : map.get(now)) {
            if (set.contains(child)) continue;
            level[child] = level[now] + 1;
            set.add(child);
            dfs(child, map, nums);
            tmp ^= or[child];
            childrenVal[now].addAll(childrenVal[child]);
            childrenVal[now].add(child);
        }
        or[now] = nums[now] ^ tmp;
    }

    public int minimumScore(int[] nums, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i <= 1000; ++i) {
            childrenVal[i] = new HashSet<>();
        }
        level[0] = 0;
        set.add(0);
        dfs(0, map, nums);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < edges.length; ++i) {
            for (int j = i + 1; j < edges.length; ++j) {
                int n1 = edges[i][0];
                int n2 = edges[i][1];
                int m1 = edges[j][0];
                int m2 = edges[j][1];

                int node1 = level[n1] > level[n2] ? n1 : n2;
                int or1 = or[node1];
                int node2 = level[m1] > level[m2] ? m1 : m2;
                int or2 = or[node2];
                if (childrenVal[node1].contains(node2)) {
                    int res = or[0] ^ or1;
                    or1 ^= or2;
                    int maxxx = Math.max(Math.max(or1, or2), res);
                    int minnn = Math.min(Math.min(or1, or2), res);
                    min = Math.min(min, maxxx - minnn);
                } else if (childrenVal[node2].contains(node1)) {
                    int res = or[0] ^ or2;
                    or2 ^= or1;
                    int maxxx = Math.max(Math.max(or1, or2), res);
                    int minnn = Math.min(Math.min(or1, or2), res);
                    min = Math.min(min, maxxx - minnn);
                } else {
                    int res = or[0] ^ or1 ^ or2;
                    int maxxx = Math.max(Math.max(or1, or2), res);
                    int minnn = Math.min(Math.min(or1, or2), res);
                    min = Math.min(min, maxxx - minnn);
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
        test.minimumScore(new int[]{1, 5, 5, 4, 11}, new int[][]{{0, 1}, {1, 2}, {1, 3}, {3, 4}});
    }
}
