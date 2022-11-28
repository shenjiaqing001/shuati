package WeeklyContest309;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/3/22
 */
public class lc4 {
    public int mostBooked(int n, int[][] meetings) {
        int[] res = new int[n + 1];
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; ++i) {
            set.add(i);
        }
        Arrays.sort(meetings, (o1, o2) -> (o1[0] - o2[0]));
        long timeNow = 0;
        // pq: int[] , 0: end time, 1: room number
        PriorityQueue<Long[]> pq = new PriorityQueue<>(((o1, o2) -> (o1[0].compareTo(o2[0]))));
        for (int i = 0; i < meetings.length; ++i) {
            timeNow = Math.max(timeNow, meetings[i][0]);
            while (!pq.isEmpty() && pq.peek()[0] <= timeNow) {
                set.add(Math.toIntExact(pq.poll()[1]));
            }
            if (set.isEmpty()) {
                timeNow = pq.peek()[0];
                while (!pq.isEmpty() && pq.peek()[0] <= timeNow) {
                    set.add(Math.toIntExact(pq.poll()[1]));
                }
            }
            int room = set.pollFirst();
            res[room]++;
            pq.add(new Long[]{timeNow + meetings[i][1] - meetings[i][0], Long.valueOf(room)});
        }
        int max = 0;
        int index = -1;
        for (int i = 0; i < n; ++i) {
            if (max < res[i]) {
                max = res[i];
                index = i;
            }
        }
        return index;
    }
}
