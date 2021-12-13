/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/12/12
 */
public class lc1891 {
    public int maxLength(int[] ribbons, int k) {
        int left = 0;
        int right = 100000;
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (count(ribbons, mid) >= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public long count(int[] ribbons, int length) {
        long count = 0;
        for (int ribbon : ribbons) {
            count += ribbon / length;
        }
        return count;
    }

}
