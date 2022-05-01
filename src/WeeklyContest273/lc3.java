package WeeklyContest273;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/25/21
 */
public class lc3 {
    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; ++i) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        long[] res = new long[arr.length];
        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            long[] presum = new long[list.size() + 1];
            for (int i = 0; i < list.size(); ++i) {
                presum[i + 1] = presum[i] + (long) list.get(i);
            }
            int size = list.size();
            for (int i = 0; i < list.size(); ++i) {
                int index = list.get(i);
                res[index] =
                        presum[size] - presum[i + 1] - (long) (list.size() - 1 - i) * (long) index
                                + (long) (i + 1 - 1) * (long) index - (presum[i] - presum[0]);
            }
        }
        return res;
    }
}
