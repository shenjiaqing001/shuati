package WeeklyContest219;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/16
 */
public class lc1688 {
    public int numberOfMatches(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 2;
            n = (n + 1) / 2;
        }
        return res;
    }
}
