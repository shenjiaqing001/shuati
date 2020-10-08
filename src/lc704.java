import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/8
 */
public class lc704 {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        if (nums[lo] == target) return lo;
        else return -1;
    }
}
