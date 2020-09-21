import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/21
 */
public class lc628 {
    public int maximumProduct(int[] nums) {
        PriorityQueue<Integer> max = new PriorityQueue<>(3, Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>(3);
        PriorityQueue<Integer> min_abs = new PriorityQueue<>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        boolean containZero = false;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) containZero = true;
            else if (nums[i] > 0) max.add(nums[i]);
            else {
                min.add(nums[i]);
                min_abs.add(nums[i]);
            }

        }

        if (max.size() == 0) {
            if (containZero == true) return 0;
            else {
                return min_abs.poll() * min_abs.poll() * min_abs.poll();
            }
        }
        if (max.size() == 1 && min.size() == 1) return 0;
        if (min.size() == 0 && max.size() <= 2) return 0;
        if (min.size() == 1 && max.size() <= 2) return 0;
        if (min.size() == 0 && max.size() >= 3) {
            return max.poll() * max.poll() * max.poll();
        }

        int min_max = min.poll() * min.poll();
        if (max.size() == 1) return min_max * max.poll();
        if (max.size() == 2) return min_max * max.poll();
        int res = max.poll();
        min_max *= res;
        res *= max.poll() * max.poll();

        return Math.max(min_max, res);
    }
}
