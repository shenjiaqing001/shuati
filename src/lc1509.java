import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/24
 */
public class lc1509 {
    public int minDifference(int[] nums) {
        if (nums.length < 4) return 0;
        PriorityQueue<Integer> pqLarge = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqSmall = new PriorityQueue<>();

        for (int num : nums) {
            pqLarge.add(num);
            pqSmall.add(num);
            if (pqLarge.size() > 4) pqLarge.poll();
            if (pqSmall.size() > 4) pqSmall.poll();
        }
        int[] small = new int[4];
        int[] large = new int[4];
        for (int i = 0; i < 4; ++i) {
            small[i] = pqSmall.poll();
            large[i] = pqLarge.poll();
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= 3; ++i) {
            min = Math.min(min, small[3 - i] - large[i]);
        }
        return min;
    }
}
