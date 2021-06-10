import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/3/5
 */
public class lc1165 {

    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; ++i) {
            map.put(keyboard.charAt(i), i);
        }

        int pos = 0;
        int res = 0;
        for (char c : word.toCharArray()) {
            res += Math.abs(map.get(c) - pos);
            pos = map.get(c);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
