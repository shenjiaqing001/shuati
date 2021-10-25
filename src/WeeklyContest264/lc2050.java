package WeeklyContest264;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/23
 */
public class lc2050 {

    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] pre = new List[n + 1];
        int[] preCount = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            pre[i] = new ArrayList<>();
        }

        for (int[] relation : relations) {
            pre[relation[0]].add(relation[1]);
            preCount[relation[1]]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; ++i) {
            if (preCount[i] == 0)
                q.add(i);
        }
        int[] finishedTime = new int[n + 1];
        int max = 0;
        while (!q.isEmpty()) {
            int tmp = q.poll();
            max = Math.max(max, finishedTime[tmp] + time[tmp - 1]);
            for (int i = 0; i < pre[tmp].size(); ++i) {
                int next = pre[tmp].get(i);
                preCount[next]--;
                finishedTime[next] =
                        Math.max(finishedTime[tmp] + time[tmp - 1], finishedTime[next]);

                if (preCount[pre[tmp].get(i)] == 0)
                    q.add(pre[tmp].get(i));
            }
        }
        return max;
    }
}
