import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/2/22
 */
public class lc630 {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (o1, o2) -> o1[1] - o2[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int now = 0;
        for (int[] course : courses) {
            now += course[0];
            pq.add(course[0]);
            if (now > course[1]) now -= pq.poll();
        }
        return pq.size();
    }
}
