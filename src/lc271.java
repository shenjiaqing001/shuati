import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/20
 */
public class lc271 {
    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                sb.append(";");
                for (char c : str.toCharArray()) {
                    sb.append('.');
                    sb.append((int) c);
                }
                sb.append(".");
            }
            sb.append(";");
            return sb.toString();
        }


        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> res = new ArrayList<>();
            String[] strs = s.split(";");
            for (int i = 1; i < strs.length; ++i) {
                StringBuilder sb = new StringBuilder();
                String[] chars = strs[i].split("\\.");
                for (int j = 1; j < chars.length; ++j) {
                    sb.append((char) (Integer.valueOf(chars[j]) + 'a' - 'a'));
                }
                res.add(sb.toString());
            }
            return res;
        }
    }
}
