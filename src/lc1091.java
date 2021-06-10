import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/2/14
 */
public class lc1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) return -1;
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        grid[0][0] = 1;
        int step = 1;

        while (true) {
            if (q.size() == 0) return -1;
            LinkedList<int[]> newQ = new LinkedList<>();
            for (int[] node : q) {
                if (node[0] == grid.length - 1 && node[1] == grid[0].length - 1) return step;
                for (int i = -1; i <= 1; ++i) {
                    for (int j = -1; j <= 1; ++j) {
                        if (node[0] + i >= 0 && node[0] + i < grid.length &&
                                node[1] + j < grid[0].length && node[1] + j >= 0)
                            if (grid[node[0] + i][node[1] + j] == 0) {
                                grid[node[0] + i][node[1] + j] = 1;
                                newQ.add(new int[]{node[0] + i, node[1] + j});
                            }
                    }
                }
            }
            q = newQ;
            step++;
        }
    }
}
