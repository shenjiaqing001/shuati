package WeeklyContest264;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/23
 */
public class lc2049 {

    Map<Integer, List<Integer>> map = new HashMap<>();
    long max = 0;
    int res = 0;
    int n;

    public int countHighestScoreNodes(int[] parents) {
        n = parents.length;
        max = n - 1;
        for (int i = 1; i < n; ++i) {
            int p = parents[i];
            map.putIfAbsent(p, new ArrayList<>());
            map.get(p).add(i);
        }
        dfs(0);

        return res;
    }

    public long dfs(int root) {
        if (!map.containsKey(root)) {
            if (max == n - 1) {
                res++;
            }
            return 1;
        }
        long product = 1;
        long left = n - 1;
        long sum = 0;
        for (int child : map.get(root)) {
            long count = dfs(child);
            product *= count;
            left -= count;
            sum += count;
        }
        if (left != 0)
            product *= left;
        if (max == product) {
            res++;
        } else if (max < product) {
            max = product;
            res = 1;
        }
        return sum + 1;
    }
}
