/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/25/20
 */
public class lc215 {
    public int findKthLargest(int[] nums, int k) {
        return findK(nums, 0, nums.length - 1, k);
    }

    public int findK(int[] nums, int left, int right, int k) {
        int lo = left, hi = right;
        int now = left;
        while (lo < hi) {
            while (nums[hi] <= nums[now] && hi > now) {
                hi--;
            }
            if (hi == now) break;
            int tmp = nums[now];
            nums[now] = nums[hi];
            nums[hi] = tmp;
            lo = now + 1;
            now = hi;

            while (nums[lo] >= nums[now] && lo < now) {
                lo++;
            }
            if (lo == now) break;
            tmp = nums[now];
            nums[now] = nums[lo];
            nums[lo] = tmp;
            hi = now - 1;
            now = lo;
        }

        if (now == k - 1) return nums[now];
        if (now > k - 1) return findK(nums, left, now - 1, k);
        if (now < k - 1) return findK(nums, now + 1, right, k);
        return 0;
    }
}
