import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/18
 */
public class lc658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0;
        int hi = arr.length-k-1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (x - arr[mid] > arr[mid + k] - x) lo = mid+1;
            else hi = mid-1;
        }
        List<Integer> res = new LinkedList<>();
        for (int i = lo; i < k + lo; ++i) res.add(arr[i]);
        return res;
    }
}
