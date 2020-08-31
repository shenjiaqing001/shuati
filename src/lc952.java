import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/31/20
 */
public class lc952 {

    int[] p;

    int get(int x) {
        if (p[x] == 0) {
            p[x] = x;
            return x;
        }
        return p[x] == x ? x : (p[x] = get(p[x]));
    }

    void add(int x, int y) {
        p[get(x)] = p[get(y)];
    }

    public int largestComponentSize(int[] A) {
        int mx = 0;
        p = new int[100000 + 1];

        for (int i : A)
            for (int j = (int) Math.sqrt(i); j >= 2; --j)
                if (i % j == 0) {
                    add(i, j);
                    add(i, i / j);
                }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : A) {
            int j = get(i);
            if (!map.containsKey(j)) map.put(j, 1);
            else map.put(j, map.get(j) + 1);
            res = Math.max(res, map.get(j));
        }
        return res;
    }
}
