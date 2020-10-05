import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/6
 */
public class lc703 {
    class KthLargest {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i = 0; i < nums.length; ++i) {
                add(nums[i]);
            }

        }

        public int add(int val) {
            if (pq.size() < k) pq.offer(val);
            else if (pq.peek() < val) {
                pq.poll();
                pq.offer(val);
            }
            return pq.peek();
        }
    }
}
