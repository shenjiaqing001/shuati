package WeeklyContest287;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/2/22
 */
public class lc3 {
    public boolean can(int[] candies, long k, long num) {
        long res = 0;
        for (int candy : candies) {
            res += candy / num;
        }
        return res >= k;
    }

    public int maximumCandies(int[] candies, long k) {
        long left = 0;
        long right = 1_000_000_0;
        while (left < right) {
            long mid = right - (right - left) / 2;
            if (can(candies, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return (int) left;
    }
}
