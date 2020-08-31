import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/29/20
 */
public class lc1324 {
    public List<String> printVertically(String s) {
        String[] str = s.split(" ");
        int max = 0;
        for (int i = 0; i < str.length; ++i) {
            max = Math.max(max, str[i].length());
        }

        List<String> res = new ArrayList<>();

        for (int i = 0; i < max; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length; ++j) {
                if (str[j].length() <= i) {
                    sb.append(" ");
                } else
                    sb.append(str[j].charAt(i));
            }
            while (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
