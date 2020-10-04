package WeeklyContest209;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/5
 */
public class lc5540 {
    public int minimumOneBitOperations(int n) {
        if (n < 2) return n;
        int m = minimumOneBitOperations(n / 2);
        return 2 * m + (n % 2 + m % 2) % 2;
    }
}
