import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/22/20
 */
public class lc253 {
    public int minMeetingRooms(int[][] intervals) {
        Comparator<int[]> cmp = (o1, o2) -> {
            if (o1[0] == o2[0])
                return o1[1] - o2[1];
            else
                return o1[0] - o2[0];
        };

        Arrays.sort(intervals, cmp);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int max = 0;
        int now = 0;
        for (int i = 0; i < intervals.length; ++i) {
            now = Math.max(now, intervals[i][0]);
            while (q.size() > 0 && q.peek() <= now) {
                q.poll();
            }
            q.add(intervals[i][1]);
            max = Math.max(max, q.size());
        }
        max = Math.max(max, q.size());
        return max;
    }
}
