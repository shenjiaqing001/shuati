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
        int count = 1;

        for (int[] edge : edges) {
            if (get(edge[0]) != get(edge[1])) {
                union(edge[0], edge[1]);
                count++;
            } else
                return false;
        }
        return count == n;
    }
}
