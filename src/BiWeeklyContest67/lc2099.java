package BiWeeklyContest67;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/11/21
 */
public class lc2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        // number index
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> (o1[0] - o2[0]));
        for (int i = 0; i < nums.length; ++i) {
            pq.add(new int[]{nums[i], i});
            if (pq.size() > k) pq.poll();
        }
        int[] tmp = new int[k];
        for (int i = 0; i < k; ++i) {
            tmp[i] = pq.poll()[1];
        }
        Arrays.sort(tmp);
        int[] res = new int[k];
        for(int i =0 ; i < k; ++i){
            res[i] = nums[tmp[i]];
        }
        return res;
    }
}
