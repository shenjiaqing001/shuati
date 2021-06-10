package WeeklyContest227;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/2/7
 */
public class lc2 {
    public int maximumScore(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        int mid = a + b + c - max - min;

        if (max > min + mid) return min + mid;
        else return (a + b + c) / 2;
    }
}
