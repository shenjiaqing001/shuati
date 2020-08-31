import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/28/20
 */
public class lc279 {
    public int numSquares(int n) {
        if (n == 0) return 0;
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        q.add(n);

        while (true) {
            res++;
            int count = q.size();
            for (int i = 1; i <= count; ++i) {
                int now = q.poll();
                int right = (int) Math.sqrt(now);
                for (int j = right; j >= 1; --j) {
                    if (now - j * j == 0) return res;
                    if (!set.contains(now - j * j)) {
                        set.add(now - j * j);
                        q.add(now - j * j);
                    }
                }
            }
        }
    }
}
