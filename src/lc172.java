/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/17/20
 */
public class lc172 {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }
}
