/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/2/22
 */
public class lc765 {
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

    public int minSwapsCouples(int[] row) {
        int n = row.length / 2;
        UnionFind uf = new UnionFind(n);
        int count = 0;
        for (int i = 0; i < n; ++i) {
            int a1 = row[2 * i];
            int a2 = row[2 * i + 1];
            if (uf.get(a1 / 2) != uf.get(a2 / 2)) {
                uf.union(a1 / 2, a2 / 2);
                count++;
            }
        }
        return count;
    }
}
