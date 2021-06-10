package WeeklyContest228;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/3/11
 */
public class lc1761 {
    public int minTrioDegree(int n, int[][] edges) {
        Map<Integer, Integer> degrees = new HashMap<>();
        boolean[][] map = new boolean[n + 1][n + 1];
        for (int[] edge : edges) {
            map[edge[0]][edge[1]] = map[edge[1]][edge[0]] = true;
            degrees.put(edge[0], degrees.getOrDefault(edge[0], 0) + 1);
            degrees.put(edge[1], degrees.getOrDefault(edge[1], 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        for (int[] edge : edges) {
            for (int i = 1; i <= n; ++i) {
                if (map[i][edge[0]] && map[i][edge[1]]) {
                    int degree = degrees.get(i) + degrees.get(edge[0]) + degrees.get(edge[1]) - 6;
                    min = Math.min(min, degree);
                }
            }
        }
        if (min == Integer.MAX_VALUE) return -1;
        else return min;
    }
}
