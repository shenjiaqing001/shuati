/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/16/20
 */
public class lc169 {
    public int majorityElement(int[] nums) {
        int last = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != last) {
                if (count == 0) {
                    count = 1;
                    last = nums[i];
                } else {
                    count--;
                }
            } else {
                count++;
            }
        }
        return last;
    }
}
