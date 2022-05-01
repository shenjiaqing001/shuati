package WeeklyContest288;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/9/22
 */
public class lc4 {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        Arrays.sort(flowers);
        for (int i = 0; i < flowers.length; ++i) {
            if (flowers[i] > target) flowers[i] = target;
        }
        int n = flowers.length;
        long[] need = new long[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            need[i] = need[i + 1] + target - flowers[i];
        }

        long[] presum = new long[n];
        presum[0] = flowers[0];
        for (int i = 1; i < n; ++i) {
            presum[i] = presum[i - 1] + flowers[i];
        }

        long maxBeauty = 0;
        int i = n - 1;
        while (i >= 0 && flowers[i] == target) {
            i--;
        }
        i++;
        for (; i >= 0; --i) {
            if (need[i] > newFlowers) break;
            long remain = newFlowers - need[i];
            int left = 0;
            int right = i - 1;
            while (left < right) {
                int mid = right - (right - left) / 2;
                long tmp = (long) flowers[mid] * (mid + 1) - presum[mid];
                if (tmp > remain) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            remain -= (long) flowers[left] * (left + 1) - presum[left];
            long can = remain / (left + 1);
            can = Math.min(can + flowers[left], target - 1);
            long count = (long) (n - i) * full + can * partial;
            if (i == 0) count -= can * partial;
            maxBeauty = Math.max(maxBeauty, count);
        }
        return maxBeauty;
    }

    public static void main(String[] args) {
        lc4 test = new lc4();
        test.maximumBeauty(new int[]{2, 4, 5, 3}, 10, 5, 2, 6);
    }
}
