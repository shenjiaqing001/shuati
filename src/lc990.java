/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/12
 */
public class lc990 {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for (String equation : equations) {
            char[] c = equation.toCharArray();
            int left = c[0] - 'a';
            int right = c[3] - 'a';
            if (c[1] == '=') {
                uf.union(left, right);
            }
        }

        for (String equation : equations) {
            char[] c = equation.toCharArray();
            int left = c[0] - 'a';
            int right = c[3] - 'a';
            if (c[1] == '!') {
                if (uf.get(left) == uf.get(right)) return false;
            }
        }

        return true;
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
