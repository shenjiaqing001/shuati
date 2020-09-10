import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/9/20
 */
public class lc1439 {
    public int kthSmallest(int[][] mat, int k) {
        PriorityQueue<Integer> res = new PriorityQueue<>(Collections.reverseOrder());
        res.add(0);
        for (int[] row : mat) {
            PriorityQueue<Integer> next = new PriorityQueue<>(Collections.reverseOrder());
            for (int prev : res)
                for (int num : row)
                    next.add(prev + num);

            while (next.size() > k)
                next.poll();
            res = next;
        }
        return res.poll();
    }
}
