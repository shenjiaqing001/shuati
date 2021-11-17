/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/16
 */
public class lc668 {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(m, n, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int m, int n, int mid, int k) {
        int count = 0;
        for (int i = 1; i <= m; ++i) {
            count += Math.min(n, mid / i);
        }
        return count >= k;
    }
}
