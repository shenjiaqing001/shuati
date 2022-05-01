import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/8/22
 */
public class lc1638 {
    public void makeMap(String s, Map<Integer, List<String>> map) {
        int n = s.length();
        for (int i = 1; i <= n; ++i) {
            map.put(i, new ArrayList<>());
            for (int j = 0; j < n; ++j) {
                if (i + j <= n) {
                    map.get(i).add(s.substring(j, i + j));
                }
            }
        }

    }

    public int countSubstrings(String s, String t) {
        Map<Integer, List<String>> maps = new HashMap<>();
        Map<Integer, List<String>> mapt = new HashMap<>();
        makeMap(s, maps);
        makeMap(t, mapt);
        int res = 0;
        int max = Math.max(s.length(), t.length());
        for (int i = 1; i <= max; ++i) {
            List<String> sList = maps.get(i);
            List<String> tList = mapt.get(i);
            if (sList != null && tList != null)
                for (String sStr : sList) {
                    for (String tStr : tList) {
                        int diff = 0;
                        char[] chars = sStr.toCharArray();
                        char[] chart = tStr.toCharArray();
                        for (int j = 0; j < i; ++j) {
                            if (chars[j] != chart[j]) diff++;
                        }
                        if (diff == 1) res++;
                    }
                }
        }
        return res;
    }

}
