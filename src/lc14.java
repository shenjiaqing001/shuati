import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/18/20
 */
public class lc14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";

        int length = strs[0].length();
        int max = length;
        String str = strs[0];


        for (int i = 1; i < strs.length; ++i) {
            if (strs[i].length() < str.length()) {
                max = strs[i].length();
                str = strs[0].substring(0, strs[i].length());
            }

            if (!strs[i].startsWith(str)) {
                int tmp = 0;
                for (tmp = 0; tmp < str.length(); ++tmp) {
                    if (str.charAt(tmp) == strs[i].charAt(tmp))
                        tmp++;
                    else
                        break;
                }
                max = tmp;
                if (max == 0)
                    break;
                str = strs[0].substring(0, max + 1);
            }
        }
        if (max == 0) return "";
        else return str;
    }
}
