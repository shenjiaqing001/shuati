/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/31/20
 */
public class lc204 {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        int res = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == false) {
                res++;
                int times = 2;
                while (i * times < n) {
                    isPrime[i * times] = true;
                    times++;
                }
            }
        }
        return res;
    }
}
