package WeeklyContest276;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/15/22
 */
public class lc2 {
    public int minMoves(int target, int maxDoubles) {
        int remain = maxDoubles;
        int res = 0;
        while (target != 1 && remain > 0) {
            if (target % 2 == 1) {
                res += 1;
                target -= 1;
            }
            target /= 2;
            res += 1;
            remain -= 1;
        }
        if (target != 1) {
            res += target - 1;
        }
        return res;
    }
}
