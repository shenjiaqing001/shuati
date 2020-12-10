/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/10
 */
public class lc261 {
    int[] p;

    int get(int x) {
        return p[x] == x ? x : (p[x] = get(p[x]));
    }

    void union(int x, int y) {
        p[get(x)] = p[get(y)];
    }

    public boolean validTree(int n, int[][] edges) {
        p = new int[n];
        for (int i = 0; i < n; ++i) p[i] = i;

        for (int i = 0; i < edges.length; ++i) {
            if (get(edges[i][0]) != get(edges[i][1])) {
                union(edges[i][0], edges[i][1]);
            } else
                return false;
        }
        int root = get(0);
        for (int i = 0; i < n; ++i) {
            if (root != get(i)) return false;
        }

        return true;
    }
}
