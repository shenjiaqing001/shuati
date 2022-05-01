package WeeklyContest283;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/5/22
 */
public class lc1 {
    public List<String> cellsInRange(String s) {
        List<String> res = new ArrayList<>();
        char[] c = s.toCharArray();

        for (Character i = c[0]; i <= c[3]; ++i) {
            for (Character j = c[1]; j <= c[4]; ++j) {
                res.add(String.valueOf((char) i + "" + (char) j));
            }
        }
        return res;
    }


}
