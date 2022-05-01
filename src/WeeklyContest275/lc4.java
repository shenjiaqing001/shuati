package WeeklyContest275;

import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/8/22
 */
public class lc4 {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o2[1] - o1[1]));
        for (int i = 0; i < n; ++i) {
            pq.add(new int[]{plantTime[i], growTime[i]});
        }

        int max = 0;
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            sum += now[0];
            max = Math.max(max, sum + now[1]);
        }
        return max;
    }
}
