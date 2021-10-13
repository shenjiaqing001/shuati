import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/12
 */
public class lc1859 {
    public String sortSentence(String s) {
        Map<Integer, String> map = new HashMap<>();
        for (String str : s.split(" ")) {
            int index = str.charAt(str.length() - 1) - '0';
            map.put(index, str.substring(0, str.length() - 1));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(map.get(1));
        for (int i = 2; i <= s.split(" ").length; ++i) {
            sb.append(" " + map.get(i));
        }
        return sb.toString();
    }
}
