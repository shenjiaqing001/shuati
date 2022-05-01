/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/5/22
 */
public class lc886 {


    public class UnionFind {
        int[] p;
        int n;

        public UnionFind(int n) {
            this.n = n;
            p = new int[2 * n + 5];
            for (int i = 0; i <= 2 * n; ++i) p[i] = i;
        }

        public int get(int x) {
            if (x < 0) return get(-x + n);
            return p[x] == x ? x : (p[x] = get(p[x]));
        }

        public void union(int x, int y) {
            int a = get(x);
            int b = get(y);
            if (p[a] < p[b]) p[b] = p[a];
            else p[a] = p[b];
        }
    }


    public boolean possibleBipartition(int n, int[][] dislikes) {
        UnionFind uf = new UnionFind(n);

        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];
            // 1 2 2 1 2 1 1 2
            if (uf.get(a) == uf.get(b)) return false;
            if (uf.get(-a) == uf.get(-b)) return false;
            uf.union(a, -b);
            uf.union(-a, b);
        }
        return true;
    }


}
