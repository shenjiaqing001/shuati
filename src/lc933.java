import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/2
 */
public class lc933 {

    class RecentCounter {
        Queue<Integer> q = new LinkedList<>();

        public RecentCounter() {

        }

        public int ping(int t) {
            q.add(t);
            while (q.peek() < t - 3000) q.poll();
            return q.size();
        }
    }

}
