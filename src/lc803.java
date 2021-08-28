

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/27
 */
public class lc803 {

    int[] p;
    int[] size;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        lc803 test = new lc803();
        test.hitBricks(new int[][]{{1, 1, 1}, {0, 1, 0}},
                new int[][]{{0, 2}, {0, 1}, {1, 1}});
    }

    int get(int x) {
        return p[x] == x ? x : (p[x] = get(p[x]));
    }

    void union(int x, int y) {
        int a = get(x);
        int b = get(y);
        if (p[a] < p[b]) {
            p[b] = p[a];
            size[a] += size[b];
        } else {
            p[a] = p[b];
            size[b] += size[a];
        }
    }

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int row = grid.length;
        int col = grid[0].length;
        int n = hits.length;
        int[] res = new int[n];
        p = new int[row * col];
        size = new int[row * col];
        for (int i = 0; i < row * col; ++i) {
            p[i] = i;
            size[i] = 1;
        }

        for (int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1)
                grid[hit[0]][hit[1]] = 0;
            else {
                hit[0] = -1;
                hit[1] = -1;
            }
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (grid[i][j] == 1) {
                    for (int[] dir : dirs) {
                        int nextx = i + dir[0];
                        int nexty = j + dir[1];
                        if (nextx < 0 || nexty < 0 || nextx >= row || nexty >= col) continue;
                        if (grid[nextx][nexty] == 0) continue;
                        if (get(i * col + j) != get(nextx * col + nexty)) {
                            union(i * col + j, nextx * col + nexty);
                        }
                    }
                }
            }
        }

        for (int i = n - 1; i >= 0; --i) {
            int[] hit = hits[i];
            if (hit[0] == -1) continue;
            grid[hit[0]][hit[1]] = 1;
            boolean flag = false;
            int count = 0;
            for (int[] dir : dirs) {
                int nextx = hit[0] + dir[0];
                int nexty = hit[1] + dir[1];
                if (nextx < 0 || nexty < 0 || nextx >= row || nexty >= col) continue;
                if (grid[nextx][nexty] == 0) continue;
                if (get(nextx * col + nexty) != get(hit[0] * col + hit[1])) {
                    if (get(nextx * col + nexty) < col || hit[0] == 0) {
                        flag = true;
                    }
                    if (get(nextx * col + nexty) >= col) {
                        count += size[get(nextx * col + nexty)];
                    }
                    union(hit[0] * col + hit[1], nextx * col + nexty);
                }
            }

            if (flag) {
                res[i] = count;
            }
        }
        return res;
    }
}
