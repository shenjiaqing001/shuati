package WeeklyContest212;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/25
 */
public class lc5548 {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        pq.add(new int[]{0, 0, 0});

        int[][] dir = new int[][]{{1, 0, -1, 0}, {0, 1, 0, -1}};
        int max = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (visited[now[0]][now[1]] == true) continue;
            max = Math.max(max, now[2]);
            visited[now[0]][now[1]] = true;
            if (now[0] == heights.length - 1 && now[1] == heights[0].length - 1) return max;
            for (int i = 0; i < 4; ++i) {
                int nextX = now[0] + dir[0][i];
                int nextY = now[1] + dir[1][i];
                if (nextX < 0 || nextY < 0 || nextX >= heights.length || nextY >= heights[0].length)
                    continue;
                if (visited[nextX][nextY] == true) continue;
                pq.add(new int[]{nextX, nextY, Math.abs(heights[now[0]][now[1]] -
                        heights[nextX][nextY])});
            }
        }
        return max;
    }
}
