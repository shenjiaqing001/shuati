import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/17
 */
public class lc1284 {
    public int minFlips(int[][] mat) {
        Set<Integer> set = new HashSet<>();

        int n = mat.length;
        int m = mat[0].length;
        int now = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                now += mat[i][j] << (i * m + n);
            }
        }
        if (now == 0) return 0;
        set.add(now);
        Queue<Integer> q = new LinkedList<>();
        q.add(now);
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; ++k) {
                int last = q.poll();
                for (int i = 0; i < n * m; ++i) {
                    int next = last;
                    next ^= 1 << i;
                    if (i - m >= 0) next ^= 1 << (i - m);
                    if (i + m < n * m) next ^= 1 << (i + m);
                    if (i % m != 0) next ^= 1 << (i - 1);
                    if (i % m != m - 1) next ^= 1 << (i + 1);
                    if (next == 0) return step;
                    if (!set.contains(next)) {
                        set.add(next);
                        q.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
