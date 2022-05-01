import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/18/22
 */
public class lc32 {
    public int longestValidParentheses(String s) {
        int tmpMax = 0;
        int leftCount = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(-1, 0);
        for (char c : s.toCharArray()) {
            if (c == '(') {
                map.put(leftCount, tmpMax);
                leftCount++;
            } else {
                if (leftCount > 0) {
                    leftCount--;
                    tmpMax += 2;
                    max = Math.max(max, tmpMax - map.get(leftCount - 1));
                } else {
                    leftCount = 0;
                    tmpMax = 0;
                    map = new HashMap<>();
                    map.put(-1, 0);

                }
            }
        }
        return max;
    }
}
