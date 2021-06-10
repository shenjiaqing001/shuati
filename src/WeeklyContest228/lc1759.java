package WeeklyContest228;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/2/14
 */
public class lc1759 {
    public int countHomogenous(String s) {
        long res = 0;
        long count = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                res += (count + 1) * count / 2;
                res %= 1000000007;
                count = 1;
            }
        }
        res += (count + 1) * count / 2;
        res %= 1000000007;
        return (int) res;
    }
}
