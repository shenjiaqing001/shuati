/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/26
 */
public class lc164 {
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) return 0;
        if (nums.length == 2) {
            return Math.max(nums[1] - nums[0], nums[0] - nums[1]);
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int n = nums.length;
        int buckets = n - 1;
        int range = (max - min) / buckets + 1;
        int[] maxBucket = new int[buckets];
        int[] minBucket = new int[buckets];

        for (int i = 0; i < maxBucket.length; ++i) {
            maxBucket[i] = Integer.MIN_VALUE;
            minBucket[i] = Integer.MAX_VALUE;
        }

        for (int num : nums) {
            int index = (num - min) / range;
            maxBucket[index] = Math.max(maxBucket[index], num);
            minBucket[index] = Math.min(minBucket[index], num);
        }
        int res = 0;
        int prev = maxBucket[0];
        for (int i = 1; i < maxBucket.length; ++i) {
            if (minBucket[i] == Integer.MAX_VALUE) continue;
            res = Math.max(res, minBucket[i] - prev);
            prev = maxBucket[i];
        }
        return res;
    }
}
