package WeeklyContest316;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 10/22/22
 */
public class lc4 {
    public long makeSimilar(int[] nums, int[] target) {
        PriorityQueue<Integer> odd = new PriorityQueue<>();
        PriorityQueue<Integer> even = new PriorityQueue<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }
        long res = 0;
        Arrays.sort(target);
        for (int num : target) {
            if (num % 2 == 0) {
                int tmp = even.poll();
                res += (long) (Math.abs(tmp - num) / 2);
            } else {
                int tmp = odd.poll();
                res += (long) (Math.abs(tmp - num) / 2);
            }
        }

        return res;
    }
}
