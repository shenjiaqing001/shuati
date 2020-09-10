package WeeklyContest205;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/6/20
 */
public class lc5510 {


    int get(int[] p, int x) {
        return p[x] == x ? x : (p[x] = get(p, p[x]));
    }

    void union(int[] p, int x, int y) {
        p[get(p, x)] = p[get(p, y)];
    }


    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int[] p = new int[n + 1];
        int res = 0;
        for (int i = 1; i <= n; ++i) p[i] = i;

        for (int i = 0; i < edges.length; ++i) {
            if (edges[i][0] == 3) {
                int x = edges[i][1];
                int y = edges[i][2];
                if (get(p, x) == get(p, y)) res++;
                else union(p, x, y);
            }
        }
        int[] p1 = p.clone();
        int[] p2 = p.clone();

        for (int i = 0; i < edges.length; ++i) {
            if (edges[i][0] == 1) {
                int x = edges[i][1];
                int y = edges[i][2];
                if (get(p1, x) == get(p1, y)) res++;
                else union(p1, x, y);
            }
        }

        for (int i = 0; i < edges.length; ++i) {
            if (edges[i][0] == 2) {
                int x = edges[i][1];
                int y = edges[i][2];
                if (get(p2, x) == get(p2, y)) res++;
                else union(p2, x, y);
            }
        }

        for (int i = 1; i <= n; ++i) if (get(p1, i) != get(p1, 1)) return -1;
        for (int i = 1; i <= n; ++i) if (get(p2, i) != get(p2, 1)) return -1;
        return res;
    }
}
