package WeeklyContest286;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/26/22
 */
public class lc2 {
    public int minDeletion(int[] nums) {
        int res = 0;
        int deleted = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1]) {
                if ((i - deleted) % 2 == 1) {
                    deleted++;
                    res++;
                }
            }
        }
        if ((nums.length - res) % 2 == 1) res++;
        return res;
    }


    public static void main(String[] args) {
        lc2 test = new lc2();
        test.minDeletion(new int[]{1, 1, 2, 2, 3, 3});
    }
}
