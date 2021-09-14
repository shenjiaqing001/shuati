package WeeklyContest211;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/18
 */
public class lc1627 {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        UnionFind uf = new UnionFind(n);
        for (int i = threshold + 1; i <= n; ++i) {
            for (int j = 2; i * j <= n; ++j) {
                uf.union(i, i * j);
            }
        }

        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < queries.length; ++i) {
            if (uf.get(queries[i][0]) == uf.get(queries[i][1]))
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }

    public class UnionFind {
        int[] p;

        public UnionFind(int n) {
            p = new int[n + 1];
            for (int i = 0; i <= n; ++i) p[i] = i;
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
