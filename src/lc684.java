/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/20
 */
public class lc684 {
    int[] p;

    int get(int x) {
        return p[x] == x ? x : (p[x] = get(p[x]));
    }

    void union(int x, int y) {
        p[get(x)] = p[get(y)];
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        p = new int[n + 1];
        for (int i = 1; i <= n; ++i) p[i] = i;
        for (int i = 0; i < edges.length; ++i) {
            if (get(edges[i][0]) == get(edges[i][1])) return edges[i];
            else union(edges[i][0], edges[i][1]);
        }
        return null;
    }
}
