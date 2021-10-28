import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/27
 */
public class lc305 {

    public static void main(String[] args) {
        lc305 test = new lc305();
        test.numIslands2(1, 2, new int[][]{{0, 1}, {0, 0}});
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind uf = new UnionFind(m * n);
        List<Integer> res = new ArrayList<>();
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[][] map = new int[m][n];
        int now = 0;
        for (int[] pos : positions) {
            if (map[pos[0]][pos[1]] == 1) {
                res.add(now);
                continue;
            }
            now++;
            map[pos[0]][pos[1]] = 1;
            for (int[] dir : dirs) {
                int nx = pos[0] + dir[0];
                int ny = pos[1] + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (map[nx][ny] == 0) continue;
                if (uf.get(nx * n + ny) != uf.get(pos[0] * n + pos[1])) {
                    now--;
                    uf.union(nx * n + ny, pos[0] * n + pos[1]);
                }
            }
            res.add(now);
        }
        return res;
    }

    public class UnionFind {
        int[] p;

        public UnionFind(int n) {
            p = new int[n];
            for (int i = 0; i < n; ++i) p[i] = i;
        }

        public int get(int x) {
            return p[x] == x ? x : (p[x] = get(p[x]));
        }

        public void union(int x, int y) {
            int a = get(x);
            int b = get(y);
            if (p[a] < p[b]) p[b] = p[a];
            else p[a] = p[b];
        }
    }
}
