import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/14/20
 */
public class lc846 {
    public boolean isNStraightHand(int[] hand, int W) {
        if (W == 1) return true;
        if (hand.length % W != 0) return false;
        int group = hand.length / W;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < group; ++i) {
            int start = map.firstKey();
            for (int j = 0; j < W; ++j) {
                if (!map.containsKey(j + start) || map.get(j + start) == 0) return false;
                int tmp = map.get(j + start) - 1;
                if (tmp == 0) map.remove(j + start);
                else map.put(j + start, tmp);
            }
        }
        return true;
    }
}
