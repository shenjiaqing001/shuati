package WeeklyContest209;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/4
 */
public class lc5531 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        int lo = 0;
        for (int i = 0; i <= 1000; ++i) {
            if (lo == nums.length) break;
            while (lo < nums.length && nums[lo] < i) lo++;
            if (nums.length - lo == i) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        lc5531 t= new lc5531();
        System.out.println(t.specialArray(new int[]{0,4,3,0,4}));
    }

}
