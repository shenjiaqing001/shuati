package BiWeeklyContest64;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/30
 */
public class lc2054 {
    public int maxTwoEvents(int[][] events) {
        // start end value
        Arrays.sort(events, (o1, o2) -> (o1[1] - o2[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o2[2] - o1[2]));
        for (int[] event : events) {
            pq.add(event);
        }
        int max = 0;
        for (int[] event : events) {
            max = Math.max(max, event[2]);
            while (!pq.isEmpty() && pq.peek()[0] <= event[1]) pq.poll();
            if (!pq.isEmpty()) {
                max = Math.max(max, event[2] + pq.peek()[2]);
            }
        }
        return max;
    }
}
