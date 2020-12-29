/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/17
 */
public class lc724 {
    public int pivotIndex(int[] nums) {
        int total = 0, sum = 0;
        for (int num : nums) total += num;
        for (int i = 0; i < nums.length; sum += nums[i++])
            if (sum * 2 == total - nums[i]) return i;
        return -1;
    }
}
