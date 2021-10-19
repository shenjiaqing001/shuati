/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/18
 */
public class lc1011 {
    public boolean check(int[] weights, int cap, int days) {
        int res = 1;
        int tmp = 0;
        for (int weight : weights) {
            if (weight > cap) return false;
            if (tmp + weight <= cap) {
                tmp += weight;
            } else {
                res++;
                tmp = weight;
            }
        }
        return res <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for (int weight : weights) sum += weight;
        int lo = sum / days;
        int hi = 2500_0000;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(weights, mid, days)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }


}
