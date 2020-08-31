/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/31/20
 */
public class lc829 {
    public int consecutiveNumbersSum(int N) {
        int res = 0;
        for (int i = 2; i <= (int) Math.sqrt(N * 2); ++i) {
            if (i % 2 == 1) {
                if (N % i == 0) res++;
            } else {
                if (N % (i / 2) == 0) {
                    int tmp = N / (i / 2);
                    if (tmp % 2 == 1)
                        res++;
                }
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {

    }
}
