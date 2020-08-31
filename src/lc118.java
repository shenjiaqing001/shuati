import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/29/20
 */
public class lc118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;

        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        res.add(tmp);
        if (numRows == 1) return res;

        tmp = new ArrayList<>();
        tmp.add(1);
        tmp.add(1);
        res.add(tmp);
        if (numRows == 2) return res;

        List<Integer> last = tmp;
        ;
        for (int i = 3; i <= numRows; ++i) {
            tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 1; j < last.size(); ++j)
                tmp.add(last.get(j - 1) + last.get(j));
            tmp.add(1);
            last = tmp;
            res.add(tmp);
        }
        return res;
    }
}
