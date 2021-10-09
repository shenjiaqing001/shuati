/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/9
 */
public class lc875 {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 1_000_000_000;
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (helper(piles, mid) <= h) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public int helper(int[] piles, int n) {
        int res = 0;
        for (int pile : piles) {
            res += (pile - 1) / n + 1;
        }
        return res;
    }
}
