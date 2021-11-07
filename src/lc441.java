/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/6
 */
public class lc441 {
    public boolean check(long n, long num) {
        long sum = (1 + num) * num / 2;
        return n >= sum;
    }

    public int arrangeCoins(int n) {
        long right = n;
        long left = 1;
        while (left < right) {
            long mid = right - (right - left) / 2;
            if (check(n, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return (int) left;
    }
}
