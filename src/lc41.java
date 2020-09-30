/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/1
 */
public class lc41 {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == index + 1) {
                index++;
                continue;
            }

            if (nums[index] > nums.length) {
                nums[index] = -1;
                index++;
                continue;
            }

            if (nums[index] <= 0) {
                index++;
                continue;
            }

            int tmp = nums[index];// index = 0,nums[index] = 5
            int tmp2 = nums[tmp - 1];
            if (tmp == tmp2) {
                nums[index] = -1;
                index++;
                continue;
            }
            nums[tmp - 1] = tmp;
            nums[index] = tmp2;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}
