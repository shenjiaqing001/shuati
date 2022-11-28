package WeeklyContest298;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 6/18/22
 */
public class lc2 {
    public int minimumNumbers(int num, int k) {
        if (num == 0) return 0;
        for (int i = 1; i <= 10; ++i) {
            if (num % 10 == (i * k) % 10) {
                if (num >= k * i)
                    return i;
            }
        }
        return -1;
    }
}
