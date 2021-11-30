import java.sql.Array;
import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/30/21
 */
public class lc1073 {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int max = Math.max(arr1.length, arr2.length);
        int[] tmp = new int[max + 2];
        for (int i = 0; i < max; ++i) {
            tmp[i] = (i < arr1.length ? arr1[arr1.length - 1 - i] : 0) +
                    (i < arr2.length ? arr2[arr2.length - 1 - i] : 0);
        }

        for (int i = 0; i < tmp.length; ++i) {
            if (tmp[i] == 3) {
                tmp[i] = 1;
                tmp[i + 1] -= 1;
            } else if (tmp[i] == 2) {
                tmp[i] = 0;
                tmp[i + 1] -= 1;
            } else if (tmp[i] == -1) {
                tmp[i] = 1;
                tmp[i + 1] += 1;
            }
        }

        Stack<Integer> q = new Stack<>();
        for (int i : tmp) q.add(i);
        while (!q.isEmpty() && q.peek() == 0) q.pop();
        if (q.size() == 0) return new int[]{0};
        int[] res = new int[q.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = q.pop();
        }
        return res;
    }
}
