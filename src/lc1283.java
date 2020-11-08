import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/7
 */
public class lc1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int left = 1;
        int right = nums[nums.length - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            int sumTmp = sumOfDivision(nums, mid);
            if (sumTmp <= threshold) {
                min = Math.min(min, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }

    public int sumOfDivision(int[] nums, int divisor) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += (nums[i] - 1) / divisor + 1;
        }
        return sum;
    }
}
