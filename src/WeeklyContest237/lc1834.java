package WeeklyContest237;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/4/21
 */
public class lc1834 {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> o1[1] == o2[1] ? o1[2] - o2[2] : o1[1] - o2[1]);

        int n = tasks.length;
        int[][] t = new int[n][3];
        for (int i = 0; i < n; ++i) {
            t[i][0] = tasks[i][0];
            t[i][1] = tasks[i][1];
            t[i][2] = i;
        }
        Arrays.sort(t, Comparator.comparingInt(o -> o[0]));

        int[] res = new int[n];
        int lastTime = 0;
        int index = 0;
        int i = 0;
        while (true) {
            if (pq.isEmpty() && index == n) break;
            if (!pq.isEmpty()) {
                int[] now = pq.poll();
                res[i++] = now[2];
                lastTime += now[1];
                while (index < n && t[index][0] <= lastTime) {
                    pq.add(new int[]{t[index][0], t[index][1], t[index][2]});
                    index++;
                }
            } else {
                lastTime = t[index][0];
                while (index < n && t[index][0] <= lastTime) {
                    pq.add(new int[]{t[index][0], t[index][1], t[index][2]});
                    index++;
                }
            }
        }
        return res;
    }
}
