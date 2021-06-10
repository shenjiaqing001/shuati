import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/20
 */
public class lc362 {
    class HitCounter {
        Queue<Integer> q = new LinkedList<>();

        /**
         * Initialize your data structure here.
         */
        public HitCounter() {

        }

        /**
         * Record a hit.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public void hit(int timestamp) {
            q.add(timestamp);
        }

        /**
         * Return the number of hits in the past 5 minutes.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public int getHits(int timestamp) {
            while (!q.isEmpty() && q.peek() <= timestamp - 300)
                q.poll();
            return q.size();
        }
    }

}
