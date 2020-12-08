import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/8
 */
public class lc914 {
    public boolean hasGroupsSizeX(int[] deck) {
        int n = deck.length;
        if (n == 1) return false;
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= (int) Math.sqrt(n); ++i) {
            if (n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
        set.add(n);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; ++i) {
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }

        for (Integer x : set) {
            boolean flag = true;
            for (Integer num : map.values()) {
                if (num % x != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
        }
        return false;
    }
}
