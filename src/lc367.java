/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/26
 */
public class lc367 {
    public boolean isPerfectSquare(int num) {
        int lo = 1;
        int hi = 46340;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (mid * mid == num) return true;
            if (mid * mid < num) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
