/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/18
 */
public class lc852 {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                lo = mid;
            }
            if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                hi = mid;
            }
        }
        return lo;
    }
}
