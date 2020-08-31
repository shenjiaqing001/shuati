/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/14/20
 */
public class lc161 {
    public boolean isOneEditDistance(String s, String t) {
        char[] shortList;
        char[] longList;
        if (s.length() >= t.length()) {
            shortList = t.toCharArray();
            longList = s.toCharArray();
        } else {
            shortList = s.toCharArray();
            longList = t.toCharArray();
        }

        if (Math.abs(s.length() - t.length()) >= 2) return false;
        if (Math.abs(s.length() - t.length()) == 1 &&
                (s.length() == 0 || t.length() == 0)) return true;

        if (s.length() == t.length()) {
            boolean flag = true;
            for (int i = 0; i < s.length(); ++i) {
                if (shortList[i] != longList[i]) {
                    if (flag == false) return false;
                    flag = false;
                }
            }
            if (flag == true) return false;
            return true;
        } else {
            int j = 0;
            for (int i = 0; i < shortList.length; ++i) {
                if (shortList[i] != longList[i + j]) {
                    if (j == 1) return false;
                    else {
                        j = 1;
                        if (shortList[i] != longList[i + j])
                            return false;
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        lc161 t = new lc161();
        System.out.println(t.isOneEditDistance("ac", "abd"));
    }
}
