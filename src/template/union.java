package template;

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
        p[get(x)] = p[get(y)];
    }
}
