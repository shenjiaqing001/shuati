import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/29/20
 */
public class lc119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();


        res.add(1);
        if (rowIndex == 0) return res;

        res.add(1);
        if (rowIndex == 1) return res;

        for (int i = 2; i <= rowIndex; ++i) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(1);
            for (int j = 1; j < res.size(); ++j)
                tmp.add(res.get(j - 1) + res.get(j));
            tmp.add(1);
            res = tmp;
        }
        return res;
    }

}
