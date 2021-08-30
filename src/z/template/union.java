package z.template;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/31/20
 */
public class union {
    int[] p;

    int get(int x) {
        return p[x] == x ? x : (p[x] = get(p[x]));
    }

    void union(int x, int y) {
        int a = get(x);
        int b = get(y);
        if (p[a] < p[b]) p[b] = p[a];
        else p[a] = p[b];
    }

}
