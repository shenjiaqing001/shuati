import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/20/21
 */
public class lc1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = arr[arr.length - 1] - arr[0];
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] - arr[i - 1] == min) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(arr[i - 1]);
                tmp.add(arr[i]);
                res.add(tmp);
            } else if (arr[i] - arr[i - 1] < min) {
                min = arr[i] - arr[i - 1];
                res = new ArrayList<>();

                List<Integer> tmp = new ArrayList<>();
                tmp.add(arr[i - 1]);
                tmp.add(arr[i]);
                res.add(tmp);
            }
        }
        return res;
    }
}
