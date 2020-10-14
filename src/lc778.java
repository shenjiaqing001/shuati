import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/15
 */
public class lc778 {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return grid[o1[0]][o1[1]] - grid[o2[0]][o2[1]];
            }
        });
        int max = 0;
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        pq.add(new int[]{0, 0});
        int[][] dir = new int[][]{{1, 0, -1, 0}, {0, 1, 0, -1}};
        isVisited[0][0] = true;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = now[0];
            int y = now[1];
            max = Math.max(max, grid[x][y]);
            if (x == grid.length - 1 && y == grid[0].length - 1) {
                return max;
            }
            for (int i = 0; i < 4; ++i) {
                int xNext = x + dir[0][i];
                int yNext = y + dir[1][i];
                if (xNext >= 0 && yNext >= 0 && xNext < grid.length && yNext < grid[0].length) {
                    if (isVisited[xNext][yNext]) continue;
                    isVisited[xNext][yNext] = true;
                    pq.add(new int[]{xNext, yNext});
                }
            }
        }
        return 0;
    }
}
