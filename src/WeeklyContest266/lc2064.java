package WeeklyContest266;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/6
 */
public class lc2064 {

    public boolean check(int[] quantities, long mid, long n) {
        long count = 0;
        for (int q : quantities) {
            count += (q - 1) / mid + 1;
        }
        return count > n;

    }

    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = 100000;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(quantities, mid, n)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
