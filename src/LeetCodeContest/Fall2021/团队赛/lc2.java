package LeetCodeContest.Fall2021.团队赛;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/25
 */
public class lc2 {
    public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
        List<int[]> list = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{position[0], position[1], 1});
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][][] visited = new boolean[terrain.length][terrain[0].length][101];
        visited[position[0]][position[1]][1] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int[] d : dir) {
                int nextx = now[0] + d[0];
                int nexty = now[1] + d[1];
                if (nextx < 0 || nexty < 0 || nextx >= terrain.length || nexty >= terrain[0].length)
                    continue;
                int nextSpeed = now[2] + terrain[now[0]][now[1]] - terrain[nextx][nexty] -
                        obstacle[nextx][nexty];
                if (nextSpeed <= 0) continue;
                if (visited[nextx][nexty][nextSpeed]) continue;
                visited[nextx][nexty][nextSpeed] = true;
                if (nextSpeed == 1) {
                    list.add(new int[]{nextx, nexty});
                }
                queue.add(new int[]{nextx, nexty, nextSpeed});
            }
        }
        int n = list.size();
        int[][] res = new int[n][2];
        for (int i = 0; i < n; ++i) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }

        Arrays.sort(res, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        return res;
    }
}
