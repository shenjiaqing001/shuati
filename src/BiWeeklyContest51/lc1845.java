package BiWeeklyContest51;

import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/1
 */
public class lc1845 {
    class SeatManager {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        public SeatManager(int n) {
            for (int i = 1; i <= n; ++i) {
                pq.add(i);
            }
        }

        public int reserve() {
            return pq.poll();
        }

        public void unreserve(int seatNumber) {
            pq.add(seatNumber);
        }
    }
}
