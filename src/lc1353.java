import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/14
 */
public class lc1353 {
    public int maxEvents(int[][] events) {
        int res = 0;
        int n = events.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        Arrays.sort(events, (o1, o2) -> (o1[0] - o2[0]));

        int index = 0;
        int time = 0;

        while (true) {
            if (pq.isEmpty() && index == n) break;
            while (index < n && events[index][0] <= time) {
                pq.add(events[index]);
                index++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < time) pq.poll();

            if (pq.isEmpty()) {
                if (index < n) {
                    time = events[index][0];
                } else {
                    break;
                }
            } else {
                pq.poll();
                time++;
                res++;
            }
        }
        return res;
    }
}
