/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/19/20
 */
public class lc201 {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0 || n / m >= 2) return 0;
        if (m == n) return m;

        int res = m;
        for (int i = m + 1; i <= n; ++i) {
            res &= i;
            if (i == n) break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(2147483647 & 2147483646);
    }
}
