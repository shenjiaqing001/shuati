package WeeklyContest204;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/30/20
 */
public class lc2 {
    public int getMaxLen(int[] nums) {

        int positve = 0;
        int negtive = 0;
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                positve++;
                if (negtive != 0)
                    negtive++;
                res = Math.max(res, positve);
            } else if (nums[i] < 0) {
                if (positve == 0) {
                    if (negtive == 0)
                        negtive++;
                    else {
                        positve = negtive + 1;
                        negtive = 1;
                    }
                } else {
                    if (negtive == 0) {
                        negtive = positve + 1;
                        positve = 0;
                    } else {
                        int tmp = positve;
                        positve = negtive + 1;
                        negtive = tmp + 1;
                    }
                }
                res = Math.max(res, positve);
            } else {
                positve = 0;
                negtive = 0;
            }
        }
        return res;
    }
}
