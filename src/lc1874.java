import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/13/22
 */
public class lc1874 {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int n = nums1.length;
        int sum = 0;
        for (int i = 0; i < nums1.length; ++i) {
            sum += nums1[i] * nums2[n - 1 - i];
        }
        return sum;
    }
}
