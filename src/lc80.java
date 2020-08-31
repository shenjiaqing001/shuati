/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/23/20
 */
public class lc80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1 || nums.length == 2)
            return nums.length;
        int res = 1;
        int last = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == last) {
                if (count < 2) {
                    count++;
                    nums[res++]=nums[i];
                }
            } else {
                last = nums[i];
                count = 1;
                nums[res++]=nums[i];
            }
        }
        return res;
    }
}
