import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/19
 */
public class lc1101 {

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (o1, o2) -> (o1[0] - o2[0]));
        UnionFind uf = new UnionFind(n);
        for (int[] log : logs) {
            if (uf.get(log[0]) != uf.get(log[1])) {
                n--;
                uf.union(log[0], log[1]);
            }
            if (n == 1) return log[0];
        }

        return -1;
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
