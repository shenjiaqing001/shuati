/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/5
 */
public class lc1492 {
    public int kthFactor(int n, int k) {
        for (int i = 1; i <= n; ++i) {
            if (n % i == 0) {
                k--;
                if (k == 0) return i;
            }
        }
        return -1;
    }
}
