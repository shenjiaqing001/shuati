/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/21/20
 */
public class lc287 {
    public int findDuplicate(int[] nums) {
        int cur = 0;
        while (cur < nums.length) {
            if (nums[cur] == cur + 1) {
                cur++;
                continue;
            }


            int tmp = nums[cur];
            if (nums[tmp - 1] == tmp) return tmp;


            nums[cur] = nums[tmp - 1];
            nums[tmp - 1] = tmp;
        }
        return nums.length;
    }
}
