import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/11/22
 */
public class lc1257 {
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> map = new HashMap<>();
        for (List<String> list : regions) {
            String father = "";
            for (String s : list) {
                if (father.equals("")) {
                    father = s;
                } else {
                    map.put(s, father);
                }
            }
        }

        Deque<String> chain1 = new ArrayDeque<>();
        Deque<String> chain2 = new ArrayDeque<>();
        while (true) {
            chain1.addLast(region1);
            if (map.containsKey(region1)) region1 = map.get(region1);
            else break;
        }
        while (true) {
            chain2.addLast(region2);
            if (map.containsKey(region2)) region2 = map.get(region2);
            else break;
        }
        String res = "";
        while (true) {
            if (chain1.isEmpty() || chain2.isEmpty()) break;
            if (Objects.equals(chain1.peekLast(), chain2.peekLast())) {
                res = chain1.peekLast();
            } else {
                break;
            }
            chain1.pollLast();
            chain2.pollLast();
        }
        return res;
    }
}
