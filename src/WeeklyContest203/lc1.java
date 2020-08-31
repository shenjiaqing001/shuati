package WeeklyContest203;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/23/20
 */
public class lc1 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int start = rounds[0];
        int end = rounds[rounds.length - 1];
        List<Integer> res = new ArrayList<>();
        if (end >= start) {
            for (int i = start; i <= end; ++i)
                res.add(i);
        } else {
            for (int i = 1; i <= end; ++i)
                res.add(i);
            for (int i = start; i <= n; ++i)
                res.add(i);
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
