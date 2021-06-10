/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/6
 */
public class lc323 {
    int[] p;

    int get(int x) {
        return p[x] == x ? x : (p[x] = get(p[x]));
    }

    void union(int x, int y) {
        p[get(x)] = p[get(y)];
    }

    public int countComponents(int n, int[][] edges) {
        p = new int[n];
        for (int i = 0; i < n; ++i) p[i] = i;
        int res = n;
        for (int i = 0; i < edges.length; ++i) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            if (get(n1) != get(n2)) {
                union(n1, n2);
                res--;
            }
        }
        return res;
    }
}
