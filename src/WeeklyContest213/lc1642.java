package WeeklyContest213;

import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/1
 */
public class lc1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < heights.length; ++i) {
            if (heights[i] <= heights[i - 1]) continue;
            int diff = heights[i] - heights[i - 1];
            pq.add(diff);
            System.out.println(diff);
            if (pq.size() > ladders) {
//                System.out.println(i + " " + pq.peek());
                bricks -= pq.poll();
            }
            if (bricks < 0) return i - 1;
        }
        return heights.length - 1;
    }
}
