package WeeklyContest227;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/2/7
 */
public class lc3 {
    public String largestMerge(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0)
            return s1 + s2;
        if (s1.compareTo(s2) > 0)
            return s1.charAt(0) + largestMerge(s1.substring(1), s2);
        return s2.charAt(0) + largestMerge(s1, s2.substring(1));
    }
}
