import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/25
 */
public class lc264 {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        pq.add((long) 1);
        int index = 1;
        while (index < n) {
            long now = pq.poll();
            index++;
            if (!set.contains(now * 2)) {
                pq.add(now * 2);
                set.add(now * 2);
            }
            if (!set.contains(now * 3)) {
                pq.add(now * 3);
                set.add(now * 3);
            }
            if (!set.contains(now * 5)) {
                pq.add(now * 5);
                set.add(now * 5);
            }
        }
        long res = pq.poll();
        return (int) res;
    }

}
