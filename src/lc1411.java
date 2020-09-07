/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/7/20
 */
public class lc1411 {
    public int numOfWays(int n) {
        long a = 6;
        long b = 6;
        while (n-- > 1) {
            long c = (2 * (a + b)) % 1000000007;
            long d = (2 * a + 3 * b) % 1000000007;
            a = c;
            b = d;
        }

        return (int) ((a + b) % 1000000007);
    }
}
