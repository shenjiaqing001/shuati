import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/21
 */
public class lc1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (o1, o2) -> o1[1] == o2[1] ? o1[2] - o2[2] : o1[1] - o2[1]);
        int right = 0;
        int now = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        while (right < trips.length) {
            now += trips[right][0];
            pq.add(trips[right]);
            while (pq.peek()[2] <= trips[right][1]) {
                now -= pq.poll()[0];
            }
            if (now > capacity) return false;
            right++;
        }
        return true;
    }
}
