/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/21
 */
public class lc1319 {
    int[] p;

    int get(int x) {
        return p[x] == x ? x : (p[x] = get(p[x]));
    }

    void union(int x, int y) {
        p[get(x)] = p[get(y)];
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        p = new int[n];
        for (int i = 0; i < n; ++i) p[i] = i;
        for (int i = 0; i < connections.length; ++i) {
            union(connections[i][0], connections[i][1]);
        }
        int count = 0;
        for (int i = 0; i < n; ++i)
            if (get(i) == i) count++;
        return count - 1;
    }
}
