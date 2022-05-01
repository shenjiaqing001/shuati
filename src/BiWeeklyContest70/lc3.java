package BiWeeklyContest70;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/22/22
 */
public class lc3 {
    //距离：定义为从 start 到一件物品的最短路径需要的步数（较近 距离的排名更高）。
    //价格：较低 价格的物品有更高优先级，但只考虑在给定范围之内的价格。
    //行坐标：较小 行坐标的有更高优先级。
    //列坐标：较小 列坐标的有更高优先级。
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start,
                                                   int k) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<int[]> q = new ArrayDeque<>();
        q.add(start);
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        vis[start[0]][start[1]] = true;
        while (!q.isEmpty() && res.size() < k) {
            int size = q.size();
            // price, x, y
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] == o2[1] ? o1[2] - o2[2] : o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
            for (int t = 0; t < size; ++t) {
                int[] cur = q.poll();
                if (grid[cur[0]][cur[1]] <= pricing[1] && grid[cur[0]][cur[1]] >= pricing[0]) {
                    pq.add(new int[]{grid[cur[0]][cur[1]], cur[0], cur[1]});
                }
                for (int[] dir : dirs) {
                    int nx = cur[0] + dir[0];
                    int ny = cur[1] + dir[1];
                    if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length) continue;
                    if (grid[nx][ny] == 0 || vis[nx][ny]) continue;
                    vis[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
            while (res.size() < k && !pq.isEmpty()) {
                int[] cur = pq.poll();
                List<Integer> tmp = new ArrayList<>();
                tmp.add(cur[1]);
                tmp.add(cur[2]);
                res.add(tmp);
            }
        }

        return res;
    }
}
