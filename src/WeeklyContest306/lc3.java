package WeeklyContest306;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/13/22
 */
public class lc3 {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n + 1; ++i) {
            list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        char[] c = pattern.toCharArray();
        for (int i = 0; i < n; ++i) {
            int count = 0;
            for (int j = i; j < n; ++j) {
                if (c[j] == 'D')
                    count++;
                else break;
            }
            if (count <= 0) {
                sb.append(list.remove(0));
            } else {
                sb.append(list.remove(count));
            }
        }
        sb.append(list.remove(0));
        return sb.toString();
    }
}
