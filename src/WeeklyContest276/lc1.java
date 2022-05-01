package WeeklyContest276;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/15/22
 */
public class lc1 {
    public String[] divideString(String s, int k, char fill) {
        List<String> list = new ArrayList<>();
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c.length; ++i) {
            sb.append(c[i]);
            if (sb.length() == k) {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        if (sb.length() != 0) {
            while (sb.length() < k) {
                sb.append(fill);
            }
            list.add(sb.toString());
        }
        return list.toArray(new String[0]);
    }
}
