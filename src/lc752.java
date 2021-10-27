import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/27
 */
public class lc752 {
    // +1 + 10 + 100 + 1000
    public int openLock(String[] deadends, String target) {
        boolean[] dp = new boolean[10000];
        for (String deadend : deadends) {
            dp[Integer.valueOf(deadend)] = true;
        }
        int t = Integer.valueOf(target);
        Queue<Integer> q = new ArrayDeque<>();
        if (dp[0]) return -1;
        dp[0] = true;
        q.add(0);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; ++s) {
                int now = q.poll();
                if (now == t) return step;
                for (int i = 1; i <= 1000; i *= 10) {
                    int nextPlus = now + i;
                    if (nextPlus / i % 10 == 0) {
                        nextPlus -= 10 * i;
                    }
                    if (!dp[nextPlus]) {
                        dp[nextPlus] = true;
                        q.add(nextPlus);
                    }

                    int nextMinus = now - i;
                    if (now / i % 10 == 0) {
                        nextMinus = now + 9 * i;
                    }
                    if (!dp[nextMinus]) {
                        dp[nextMinus] = true;
                        q.add(nextMinus);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
