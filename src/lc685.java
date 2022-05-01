import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/27/21
 */
public class lc685 {

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

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);
        Map<Integer, Integer> inDegree = new HashMap<>();
        int[] candidate = new int[]{-1, -1};
        int[] tmpEdge = new int[2];
        for (int[] edge : edges) {
            if (inDegree.containsKey(edge[1])) {
                candidate = edge;
            } else {
                inDegree.put(edge[1], edge[0]);
                if (uf.get(edge[0]) == uf.get(edge[1])) tmpEdge = edge;
                uf.union(edge[0], edge[1]);
            }
        }
        if (candidate[0] == -1) return tmpEdge;
        if (uf.get(candidate[0]) == uf.get(candidate[1])) return candidate;
        else return new int[]{inDegree.get(candidate[1]), candidate[1]};
    }
}
