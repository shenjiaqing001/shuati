import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/25
 */
public class lc373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(((o1, o2) -> (-o1[0] - o1[1] + o2[0] + o2[1])));

        for (int i = 0; i < nums1.length && i < k; ++i) {
            for (int j = 0; j < nums2.length && j < k; ++j) {
                int sum = nums1[i] + nums2[j];
                if (pq.size() < k || pq.peek()[0] + pq.peek()[1] > sum) {
                    pq.add(new int[]{nums1[i], nums2[j]});
                }
                if (pq.size() > k) pq.poll();
            }
        }

        List<List<Integer>> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(pq.peek()[0]);
            tmp.add(pq.poll()[1]);
            res.add(0, tmp);
        }
        return res;
    }
}
