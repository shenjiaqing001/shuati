/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/21/20
 */
public class lc75 {
    public void sortColors(int[] nums) {
        int[] colorCount = new int[3];
        for (int i = 0; i < nums.length; ++i) {
            colorCount[nums[i]]++;
        }
        for (int i = 0; i < colorCount[0]; ++i)
            nums[i] = 0;
        for (int i = colorCount[0]; i < colorCount[0] + colorCount[1]; ++i)
            nums[i] = 1;
        for (int i = colorCount[0] + colorCount[1]; i < nums.length; ++i)
            nums[i] = 2;
    }
}
