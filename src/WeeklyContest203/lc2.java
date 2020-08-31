package WeeklyContest203;

import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/23/20
 */
public class lc2 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res = 0;
        int get = piles.length / 3;
        for (int i = piles.length - 2; i > 0; i -= 2) {
            res += piles[i];
            get--;
            if (get == 0) break;
        }
        return res;
    }
}
