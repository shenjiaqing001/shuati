package WeeklyContest307;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/20/22
 */
public class lc4 {
    public long kSum(int[] nums, int k) {
        PriorityQueue<Long[]> pq = new PriorityQueue<>((a, b) -> b[0].compareTo(a[0]));
        int[] absArray = Arrays.stream(nums).map(i -> Math.abs(i)).toArray();

        Arrays.sort(absArray);
        long maxSum = 0;
        for (int num : nums)
            if (num > 0)
                maxSum += num;

        pq.add(new Long[]{Long.valueOf(maxSum - absArray[0]), 0l});

        List<Long> ans = new ArrayList<>();
        ans.add(maxSum);
        int n = nums.length;

        while (ans.size() < k) {
            Long cur[] = pq.poll();
            long curSum = cur[0];
            int i = Math.toIntExact(cur[1]);
            ans.add(curSum);

            if (i + 1 < n) {
                pq.add(new Long[]{curSum + absArray[i] - absArray[i + 1], Long.valueOf(i + 1)});
                pq.add(new Long[]{curSum - absArray[i + 1], Long.valueOf((i + 1))});
            }

        }
        return ans.get(k - 1);
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
        test.kSum(new int[]{1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008, 1009}, 10);

    }
}
