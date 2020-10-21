import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/22
 */
public class lc544 {
    public String findContestMatch(int n) {
        Map<Integer, StringBuffer> map = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            map.put(i, new StringBuffer().append(i));
        }
        while (n > 1) {
            int sum = n + 1;
            for (int i = 1; i <= n / 2; ++i) {
                map.get(i).insert(0, '(').append(',').append(map.get(sum - i)).append(')');
            }
            n /= 2;
        }
        return map.get(1).toString();
    }
}
