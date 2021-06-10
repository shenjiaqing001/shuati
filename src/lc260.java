/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/25
 */
public class lc260 {
    public int[] singleNumber(int[] nums) {
        if (nums.length == 2) return nums;
        int xor = 0;

        for (int i = 0; i < nums.length; ++i) {
            xor ^= nums[i];
        }
        xor = Integer.highestOneBit(xor);
        int num1 = 0;
        int num2 = 0;

        for (int num : nums) {
            if ((xor & num) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {

        System.out.println(-1 ^ -4);

        int xor = 6;
        System.out.println(Integer.highestOneBit(xor));
        System.out.println(6 & 4);
    }
}
