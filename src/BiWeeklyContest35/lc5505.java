package BiWeeklyContest35;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/19
 */
public class lc5505 {
    int n;
    int[] c = new int[100005];

    public int lowbit(int x) {
        return x & (-x);
    }

    public void add(int x, int d) {
        while (x <= n) {
            c[x] += d;
            x += lowbit(x);
        }
    }

    public int sum(int x) {
        int res = 0;
        while (x > 0) {
            res += c[x];
            x -= lowbit(x);
        }
        return res;
    }

    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int length = nums.length;
        n = length;
        for (int i = 0; i < requests.length; ++i) {
            add(requests[i][0] + 1, 1);
            add(requests[i][1] + 2, -1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.sort(nums);

        for (int i = 1; i <= length; ++i) {
            pq.add(sum(i));
        }
        int pos = nums.length - 1;
        long res = 0;
        while (!pq.isEmpty()) {
            int now = pq.poll();
//            System.out.println(now);
            res += now * nums[pos--];
            res %= 1000000007;
        }
        return (int) res;
    }
}
