package WeeklyContest293;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 5/14/22
 */
public class lc1 {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        Map<Integer, Integer> lastMap = new HashMap<>();
        for (String s : words) {
            Map<Integer, Integer> tmp = new HashMap<>();
            for (char c : s.toCharArray()) {
                tmp.put(c - 'a', tmp.getOrDefault(c - 'a', 0) + 1);
            }
            boolean flag = true;
            if (lastMap.size() != tmp.size()) flag = false;
            else {
                for (Integer key : lastMap.keySet()) {
                    if (!tmp.containsKey(key)) {
                        flag = false;
                        break;
                    }
                    if (!Objects.equals(lastMap.get(key), tmp.get(key))) {
                        flag = false;
                        break;
                    }
                }
            }
            if (!flag) {
                res.add(s);
                lastMap = tmp;
            }
        }
        return res;
    }
}
