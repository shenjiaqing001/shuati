package BiWeeklyContest71;

import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/10/22
 */
public class lc2163 {
    public long minimumDifference(int[] nums) {
        TreeSet<Integer> left = new TreeSet<>((o1, o2) -> {
            if (nums[o1] == nums[o2]) return o1 - o2;
            else return nums[o1] - nums[o2];
        });
        TreeSet<Integer> right = new TreeSet<>((o1, o2) -> {
            if (nums[o1] == nums[o2]) return o1 - o2;
            else return nums[o1] - nums[o2];
        });
        TreeSet<Integer> removed = new TreeSet<>((o1, o2) -> {
            if (nums[o1] == nums[o2]) return o1 - o2;
            else return nums[o1] - nums[o2];
        });
        int n = nums.length / 3;
        long sum = 0;
        for (int i = 0; i < 2 * n; ++i) {
            left.add(i);
            sum += nums[i];
        }

        while (left.size() > n) {
            int index = left.last();
            removed.add(index);
            sum -= nums[index];
            left.remove(index);
        }
        for (int i = 2 * n; i < 3 * n; ++i) {
            right.add(i);
            sum -= nums[i];
        }
        long min = sum;
        for (int i = 2 * n - 1; i >= n; --i) {
            if (removed.contains(i)) {
                removed.remove(i);
                right.add(i);
                sum -= nums[i];
                int index = right.pollFirst();
                sum += nums[index];
            } else {
                left.remove(i);
                sum -= nums[i];
                right.add(i);
                sum -= nums[i];
                int index = right.pollFirst();
                sum += nums[index];
                int index2 = removed.pollFirst();
                left.add(index2);
                sum += nums[index2];
            }
            min = Math.min(min, sum);
        }
        return min;
    }
}
