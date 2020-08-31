import javax.swing.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/30/20
 */
public class lc560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] sum = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i == 0)
                sum[i] = nums[0];
            else
                sum[i] = nums[i] + sum[i - 1];

            List<Integer> list = map.getOrDefault(sum[i], new LinkedList<>());
            list.add(i);
            map.put(sum[i], list);

        }
        for (int i = 0; i < nums.length; ++i) {
            System.out.println(sum[i]);
            if (sum[i] == k) res++;
            if (map.containsKey(sum[i] - k)) {
                List<Integer> list = map.get(sum[i] - k);
                for (Integer index : list) {
                    if (index <= i)
                        res++;
                }
            }
        }
        return res;
    }
}
