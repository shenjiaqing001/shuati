import javax.swing.*;
import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/25/20
 */
public class lc347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (Integer key : map.keySet()) {
            if (bucket[map.get(key)] == null) {
                bucket[map.get(key)] = new LinkedList<>();
            }
            bucket[map.get(key)].add(key);
        }

        int[] res = new int[k];
        int now = 0;
        for (int i = bucket.length - 1; i > 0 && k > 0; --i) {
            if (bucket[i] != null) {
                for (Integer key : bucket[i]) {
                    res[now++] = key;
                    k--;
                }
            }
        }
        return res;
    }


    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[1] - o2[1]));
        for (int key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
            if (pq.size() > k) pq.poll();
        }
        int[] res = new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = pq.poll()[0];
        }
        return res;
    }

}
