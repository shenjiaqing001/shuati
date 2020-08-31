import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/24/20
 */
public class lc89 {
    /**
     * 0 0 0
     * 0 0 1
     * 0 1 1
     * 0 1 0
     * 1 1 0
     * 1 1 1
     * 1 0 1
     * 1 0 0
     * <p>
     * 0 0 0 0
     * 0 0 0 1
     * 0 0 1 1
     * 0 0 1 0
     * 0 1 1 0
     * 0 1 1 1
     * 0 1 0 1
     * 0 1 0 0
     * 1 1 0 0
     * 1 1 0 1
     * 1 1 1 1
     * 1 1 1 0
     * 1 0 1 0
     * 1 0 1 1
     * 1 0 0 1
     * 1 0 0 0
     */

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        if (n == 0) return list;
        list.add(1);
        if (n == 1) return list;

        int multiple = 1;
        int start = 1;
        for (int i = 2; i <= n; ++i) {
            multiple *= 2;
            start *= 2;
            for (int j = start - 1; j >= 0; --j) {
                list.add(list.get(j) + multiple);
            }
        }
        return list;
    }


}
