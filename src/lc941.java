/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/11
 */
public class lc941 {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;
        if (arr[0] >= arr[1]) return false;
        if (arr[n - 2] <= arr[n - 1]) return false;

        int tmp = 2;
        while (tmp < n && arr[tmp] > arr[tmp - 1]) tmp++;
        if (tmp == n) return false;
        while (tmp < n && arr[tmp] < arr[tmp - 1]) tmp++;
        if (tmp != n) return false;
        return true;
    }
}
