import java.util.Random;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/25/20
 */
public class lc215 {
    Random random = new Random();

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

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k);
    }

    public int findKthLargest2(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    public int quickSort(int[] nums, int left, int right, int k) {
        int r = random.nextInt(right - left + 1) + left;
        int mid = partition(nums, left, right, r);
        if (mid == k - 1) return nums[mid];
        if (mid > k - 1) return quickSort(nums, left, mid - 1, k);
        if (mid < k - 1) return quickSort(nums, mid + 1, right, k);
        return 0;
    }

    public int partition(int[] nums, int left, int right, int pivot) {
        swap(nums, pivot, right);
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[i] < nums[right]) ++i;
            while (i < j && nums[j] >= nums[right]) --j;
            swap(nums, i, j);
        }
        swap(nums, i, right);
        return i;
    }

    public void swap(int[] nums, int p1, int p2) {
        int tmp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = tmp;
    }
}
