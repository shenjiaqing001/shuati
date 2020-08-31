/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/28/20
 */
public class lc727 {
    public String minWindow(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        String res = "";
        int min = Integer.MAX_VALUE;
        int sIndex = 0;
        int tIndex = 0;

        while (sIndex < s.length) {
            if (s[sIndex] == t[tIndex]) {
                tIndex++;
                if (tIndex == t.length) {
                    int now = sIndex;
                    tIndex--;
                    while (tIndex >= 0) {
                        if (s[sIndex] == t[tIndex]) {
                            tIndex--;
                        }
                        sIndex--;
                    }
                    sIndex++;
                    tIndex++;

                    if (min > now - sIndex + 1) {
                        res = S.substring(sIndex, now + 1);
                        min = res.length();
                    }
                }
            }
            sIndex++;
        }
        return res;
    }

    public static void main(String[] args) {
        lc727 t = new lc727();
        System.out.println(t.minWindow("abcdebdde", "bde"));
    }
}
