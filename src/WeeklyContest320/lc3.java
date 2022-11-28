package WeeklyContest320;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/19/22
 */
public class lc3 {

    int[] count;
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();

    public int dfs(Integer root, Integer d) {
        if (set.contains(root)) return 0;
        set.add(root);
        int sum = 0;
        for (int neighbor : map.get(root)) {
            sum += dfs(neighbor, d + 1);
        }
        count[root] = sum + 1;
        return count[root];
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 0) return 0;
        int n = roads.length;
        count = new int[roads.length + 1];
        for (int[] road : roads) {
            map.putIfAbsent(road[0], new ArrayList<>());
            map.putIfAbsent(road[1], new ArrayList<>());
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }
        dfs(0, 0);
        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += (count[i] + seats - 1) / seats;
        }
        return res;
    }

    public static void main(String[] args) {
        lc3 test = new lc3();
        System.out.println(test.minimumFuelCost(new int[][]{{0, 1}, {0, 2}, {0, 3}}, 5));
    }
}
