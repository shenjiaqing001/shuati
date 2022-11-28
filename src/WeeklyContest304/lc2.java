package WeeklyContest304;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/30/22
 */
public class lc2 {
    public int maximumGroups(int[] grades) {
        int n = grades.length;
        int res = 0;
        while (res * (res + 1) / 2 <= n) {
            res++;
        }
        return res - 1;
    }
    // 1, 3, 6, 10, 15.
    // n * (n + 1) / 2 == length
    // n(n+1) = 2*length
    // n = sqrt(2 * length)
}
