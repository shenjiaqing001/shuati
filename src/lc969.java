import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/29/20
 */
public class lc969 {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> res = new LinkedList<>();
        int[] index = new int[A.length + 1];
        for (int i = 0; i < A.length; ++i) {
            index[A[i]] = i + 1;
        }
        for (int i = A.length; i >= 1; --i) {
            int old = index[i];
            for (Integer num : res) {
                if (old > num) continue;
                old = num - old + 1;
            }
            if (old == i)
                continue;
            res.add(old);
            res.add(i);
        }
        return res;
    }
}
