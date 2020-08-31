import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/25/20
 */
public class lc93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        recursive(res, "", s, 0, 0);
        return res;
    }

    public void recursive(List<String> res, String ip, String s, int index,
                          int count) {
        if (count == 4) {
            if (index == s.length()) {
                res.add(ip.substring(0, ip.length() - 1));
            }
            return;
        } else {
            for (int i = index + 1; i <= s.length() && i <= index + 3; ++i) {
                if (Integer.valueOf(s.substring(index, i)) <= 255) {
                    recursive(res, ip + s.substring(index, i) + ".", s, i,
                            count + 1);
                }
                if (s.charAt(index) == '0')
                    break;
            }
        }
    }

    public static void main(String[] args) {
        lc93 t = new lc93();
        System.out.println(t.restoreIpAddresses("25525511135"));
    }
}
