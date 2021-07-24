package WeeklyContest250;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/17
 */
public class lc1936 {
    public int addRungs(int[] rungs, int dist) {
        int cur = 0;
        int res = 0;
        for (int rung : rungs) {
            res += (rung - 1 - cur) / dist;
            cur = rung;
        }
        return res;
    }
}
