package WeeklyContest221;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/27
 */
public class lc1705 {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 0;
        int n = apples.length;
        for (int i = 0; i < n; ++i) {
            while (!q.isEmpty() && (q.peek()[1] < i || q.peek()[0] == 0)) {
                q.poll();
            }
            if (apples[i] != 0)
                q.add(new int[]{apples[i], days[i] + i});
            if (!q.isEmpty()) {
                q.peek()[0]--;
                count++;
            }
        }
        System.out.println(count);
        int now = n;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            System.out.println(poll[0] + " " + poll[1]);
            if (poll[0] == 0 || poll[1] <= now) continue;
            count += Math.min(poll[0], poll[1] - now);
            now = count + now;
        }

        return count;
    }
}
