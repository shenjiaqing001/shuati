import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/29
 */
public class lc932 {
    public int[] beautifulArray(int n) {
        int[] res = new int[n];

        List<Integer> list = new ArrayList<>();
        list.add(1);
        while (list.size() < n) {
            List<Integer> tmp = new ArrayList<>();
            for (int num : list) if (num * 2 - 1 <= n) tmp.add(num * 2 - 1);
            for (int num : list) if (num * 2 <= n) tmp.add(num * 2);
            list = tmp;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
