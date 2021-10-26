/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/26
 */
public class lc1231 {
    public int maximizeSweetness(int[] sweetness, int k) {
        k += 1;
        int sum = 0;
        for (int sweet : sweetness) {
            sum += sweet;
        }
        int lo = 1;
        int hi = sum / k;
        while (lo < hi) {
            int mid = hi - (hi - lo) / 2;
            System.out.println(lo + " " + hi + " " + mid);
            if (check(sweetness, k, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public boolean check(int[] sweetness, int k, int sweet) {
        int sum = 0;
        int count = 0;
        for (int s : sweetness) {
            sum += s;
            if (sum >= sweet) {
                count += 1;
                sum = 0;
            }
        }
        return count >= k;
    }
}
