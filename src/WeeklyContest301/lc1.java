package WeeklyContest301;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/9/22
 */
public class lc1 {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int small = amount[0] + amount[1];
        if (small >= amount[2]) {
            return (amount[1] + amount[0] + amount[2] + 1) / 2;
        } else {
            return amount[2];
        }
    }
}
