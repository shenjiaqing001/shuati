package WeeklyContest256;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/28
 */
public class lc1986 {
    public static void main(String[] args) {
        lc1986 test = new lc1986();
        System.out.println(test.minSessions2(new int[]{1, 2, 3}, 3));
    }

    public int minSessions(int[] tasks, int sessionTime) {
        int min = tasks.length;
        List<Integer> list = new ArrayList<>();
        for (int i : tasks) {
            list.add(i);
        }

        for (int i = 0; i < 10000; ++i) {
            int ans = 0;
            int count = 1;
            for (int task : list) {
                if (ans + task > sessionTime) {
                    count++;
                    ans = 0;
                }
                ans += task;
            }
            min = Math.min(min, count);

            Collections.shuffle(list);
        }
        return min;
    }

    public int minSessions2(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int state = 1;
        for (int i = 0; i < tasks.length; ++i) {
            state *= 2;
        }
        int[] dp = new int[state];
        Arrays.fill(dp, 20);
        for (int i = 0; i < state; ++i) {
            int sum = 0;
            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) > 0) sum += tasks[j];
            }
            if (sum <= sessionTime) dp[i] = 1;
        }

        for (int i = 1; i < state; i++) {
            for (int subset = i; subset > 0; subset = (subset - 1) & i) {
                dp[i] = Math.min(dp[i], dp[subset] + dp[i - subset]);
            }
        }
        return dp[state - 1];
    }
}
