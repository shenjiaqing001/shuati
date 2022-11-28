package WeeklyContest294;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/21/22
 */
public class lc4 {
    public int totalStrength(int[] strength) {
        long mod = 1_000_000_007;
        int n = strength.length;
        long[] presum = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            presum[i] = presum[i - 1] + strength[i - 1];
        }
        long[] sumsum = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            sumsum[i] = sumsum[i - 1] + presum[i];
        }
        long res = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{-1, -5});
        for (int i = 0; i <= n; ++i) {
            long nowValue = i == n ? -1 : strength[i];
            while (deque.peekLast()[1] >= nowValue) {
                int[] polled = deque.pollLast();
                long tmpRight = sumsum[i] - sumsum[polled[0]];
                long length2 = polled[0] - deque.peekLast()[0];
                long length1 = i - polled[0];
                long tmpLeft = deque.peekLast()[0] == -1 ?
                        sumsum[polled[0]] : sumsum[polled[0]] - sumsum[deque.peekLast()[0]];
                res += ((((tmpRight % mod) * length2 - (tmpLeft % mod) * length1) % mod + mod) %
                        mod) * polled[1];
                res %= mod;
            }
            if (i < n)
                deque.add(new int[]{i, strength[i]});
        }
        return (int) res;
    }


    public static void main(String[] args) {
        lc4 test = new lc4();
        test.totalStrength(new int[]{1, 3, 1, 2});
    }
}
