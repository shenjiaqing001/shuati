package WeeklyContest282;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/26/22
 */
public class lc3 {

    public long check(int[] time, long t) {
        long count = 0;
        for (int tt : time) {
            count += t / tt;
            if (count >= 1_000_000_0) return count;
        }
        return count;
    }

    public long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long right = Long.MAX_VALUE;
        while (left < right) {
            long mid = (right - left) / 2 + left;
            if (check(time, mid) < totalTrips) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
