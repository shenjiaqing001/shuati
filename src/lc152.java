/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/12/20
 */
public class lc152 {
    public int maxProduct(int[] nums) {
        int max = 0;
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];

        int maxBig0 = 0;
        int maxMin0 = 0;
        for (int i = 0; i < length; ++i) {
            if (nums[i] == 0) {
                max = Math.max(max, maxBig0);
                maxBig0 = 0;
                maxMin0 = 0;
                continue;
            }
            if (nums[i] > 0) {
                maxMin0 *= nums[i];
                if (maxBig0 == 0)
                    maxBig0 = nums[i];
                else
                    maxBig0 *= nums[i];
            } else {
                if (maxMin0 != 0) {
                    int tmp = maxBig0;
                    maxBig0 = maxMin0 * nums[i];
                    maxMin0 = tmp * nums[i];
                } else {
                    max = Math.max(max, maxBig0);
                    if (maxBig0 == 0) {
                        maxMin0 = nums[i];
                    } else {
                        maxMin0 = maxBig0 * nums[i];
                    }
                    maxBig0 = 0;
                }
            }
        }
        max = Math.max(maxBig0, max);
        return max;
    }
}
