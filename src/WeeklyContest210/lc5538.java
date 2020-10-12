package WeeklyContest210;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/11
 */
public class lc5538 {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; ++i) {
            map.putIfAbsent(edges[i][0], new ArrayList<>());
            map.putIfAbsent(edges[i][1], new ArrayList<>());
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        int[] res = new int[n - 1];
        for (int i = 1; i <= (1 << n) - 1; ++i) {
            check(map, res, n, i);
        }
        return res;
    }

    public void check(Map<Integer, List<Integer>> map, int[] res, int n, int num) {
        Set<Integer> subTree = new HashSet<>();
        int start = 0;
        for (int i = 1; i <= n; ++i) {
            if ((num >> (i - 1) & 1) == 1) {
                subTree.add(i);
                start = i;
            }
        }
        if (subTree.size() == 1) return;
        Map<Integer, Integer> tmp = new HashMap<>();
        tmp.put(start, 0);
        dfs(map, subTree, tmp, start, start);
        if (tmp.size() != subTree.size()) return;
        int max = 0;
        for (Integer maxone : tmp.keySet()) {
            if (max < tmp.get(maxone)) {
                max = tmp.get(maxone);
                start = maxone;
            }
        }

        tmp = new HashMap<>();
        tmp.put(start, 0);
        dfs(map, subTree, tmp, start, start);
        max = 0;
        for (Integer maxone : tmp.keySet()) {
            if (max < tmp.get(maxone)) {
                max = tmp.get(maxone);
            }
        }
        res[max - 1]++;
    }

    public void dfs(Map<Integer, List<Integer>> map, Set<Integer> subTree,
                    Map<Integer, Integer> tmp, int now, int last) {
        List<Integer> canGO = map.get(now);
        for (Integer next : canGO) {
            if (next == last) continue;
            if (!subTree.contains(next)) continue;
            tmp.put(next, tmp.get(now) + 1);
            dfs(map, subTree, tmp, next, now);
        }
    }


    public static void main(String[] args) {

//        System.out.println(5 >>> 2 & 1);

//        for (int i = 1; i <= (1 << 5) - 1; ++i) {
//            System.out.println(Integer.toBinaryString(i));
//        }
        int n = 21;
        for (int i = 0; i < 5; ++i) {
            System.out.println(n >> i & 1);
        }
    }


}
