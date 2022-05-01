package BiWeeklyContest71;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/10/22
 */
public class lc2160 {
    public int minimumSum(int num) {
        int a = num % 10;
        int b = num / 10 % 10;
        int c = num / 100 % 10;
        int d = num / 1000;
        int min = Integer.MAX_VALUE;
        min = Math.min(10 * a + b + 10 * c + d, min);
        min = Math.min(10 * b + a + 10 * c + d, min);
        min = Math.min(10 * a + b + 10 * d + c, min);
        min = Math.min(10 * b + a + 10 * d + c, min);
        min = Math.min(10 * a + c + 10 * b + d, min);
        min = Math.min(10 * c + a + 10 * d + b, min);
        return min;
    }
}
