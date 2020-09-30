/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/1
 */
public class lc1060 {
    public int missingElement(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        int totalMissing = nums[hi] - nums[0] - nums.length + 1;
        if (k > totalMissing) return nums[hi] + k - totalMissing;


        while (lo < hi - 1) {
            int mid = lo + (hi - lo) / 2;
            int missing = nums[mid] - nums[lo] - (mid - lo);
            if (missing >= k) {
                hi = mid;
            } else {
                k -= missing;
                lo = mid;
            }

        }
        return nums[lo] + k;
    }
}
