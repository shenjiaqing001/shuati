import java.security.Key;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/13
 */
public class lc781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < answers.length; ++i) {
            map.put(answers[i], map.getOrDefault(answers[i], 0) + 1);
        }

        for (Integer num : map.keySet()) {
            int value = map.get(num);
            int times = value / (num + 1);
            int remain = value % (num + 1);
            res += times * (num + 1);
            if (remain > 0) res += num + 1;
        }
        return res;
    }
}
