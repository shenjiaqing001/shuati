import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/25
 */
public class lc947 {

    Map<Integer, Integer> xMap = new HashMap<>();
    Map<Integer, Integer> yMap = new HashMap<>();

    public int removeStones(int[][] stones) {
        int n = stones.length;
        int res = n;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < stones.length; ++i) {
            if (xMap.containsKey(stones[i][0])) {
                uf.union(xMap.get(stones[i][0]), i);
                res--;
            } else {
                xMap.put(stones[i][0], i);
            }
            if (yMap.containsKey(stones[i][1])) {
                if (uf.get(i) != uf.get(yMap.get(stones[i][1]))) {
                    uf.union(yMap.get(stones[i][1]), i);
                    res--;
                }
            } else {
                yMap.put(stones[i][1], i);
            }
        }
        return n - res;
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
