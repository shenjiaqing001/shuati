package WeeklyContest211;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/18
 */
public class lc1627 {
    int[] p;

    int get(int x) {
        return p[x] == x ? x : (p[x] = get(p[x]));
    }

    void union(int x, int y) {
        p[get(x)] = p[get(y)];
    }

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        p = new int[n + 1];
        for (int i = 1; i <= n; ++i) p[i] = i;

        for (int i = threshold + 1; i <= n; ++i) {
            for (int j = 2; ; ++j) {
                if (i * j > n) break;
                union(i, i * j);
            }
        }
        List<Boolean> res = new ArrayList<>();

        for (int i = 0; i < queries.length; ++i) {
            if (get(queries[i][0]) == get(queries[i][1]))
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
}
