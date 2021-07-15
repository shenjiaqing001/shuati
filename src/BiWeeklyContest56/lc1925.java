package BiWeeklyContest56;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/10
 */
public class lc1925 {
    public int countTriples(int n) {
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = i; j <= n; ++j) {
                int sqrt = (int) Math.sqrt(i * i + j * j);
                if (sqrt > n) continue;
                if (sqrt * sqrt == i * i + j * j) {
                    if (i == j) res++;
                    else res += 2;
                }
            }
        }
        return res;
    }
}
