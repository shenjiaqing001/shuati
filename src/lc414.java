import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/11
 */
public class lc414 {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) continue;
            else set.add(nums[i]);
            if (pq.size() < 3) pq.add(nums[i]);
            else {
                if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        if (pq.size() >= 3) return pq.poll();
        while (pq.size() > 1) pq.poll();
        return pq.poll();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(2);
        pq.add(1);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

    }
}
