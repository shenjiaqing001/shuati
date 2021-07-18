package WeeklyContest249;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/10
 */
public class lc1931 {
    public int colorTheGrid(int m, int n) {
        // m 列 n 行
        int stats = 1;
        for (int i = 0; i < m; ++i) {
            stats *= 3;
        }
        int mod = 1_000_000_007;

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[][] dp = new int[n][stats];
        for (int i = 0; i < stats; ++i) {
            if (checkState(i, m)) {
                dp[0][i] = 1;
                map.put(i, new LinkedList<>());
            }
        }

        Set<Integer> keySet = map.keySet();
        for (int i : keySet) {
            for (int j : keySet) {
                if (i == j) continue;
                if (!checkNext(i, j, m)) continue;
                map.get(i).add(j);
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int j : keySet) {
                for (int k : map.get(j)) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= mod;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < stats; ++i) {
            sum += dp[n - 1][i];
            sum %= mod;
        }
        return sum;
    }

    public boolean checkState(int state, int m) {
        int last = state % 3;
        for (int i = 1; i < m; ++i) {
            state /= 3;
            if (state % 3 == last) return false;
            last = state % 3;
        }
        return true;
    }

    public boolean checkNext(int state1, int state2, int m) {
        for (int i = 0; i < m; ++i) {
            int mod1 = state1 % 3;
            int mod2 = state2 % 3;
            if (mod1 == mod2) return false;
            state1 /= 3;
            state2 /= 3;
        }
        return true;
    }


    public static void main(String[] args) {
        lc1931 test = new lc1931();
        System.out.println(test.colorTheGrid(5, 5));
    }
}
