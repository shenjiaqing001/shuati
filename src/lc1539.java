/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/6
 */
public class lc1539 {
    public int findKthPositive(int[] A, int k) {
        int low = 0;
        int high = A.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cal = A[mid] - mid - 1;
            if (cal >= k)
                high = mid;
            else
                low = mid + 1;
        }
        return low + k;
    }
}
