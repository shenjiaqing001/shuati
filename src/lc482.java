/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/20
 */
public class lc482 {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        char[] c = S.toUpperCase().toCharArray();
        int count = 0;
        for (int i = S.length() - 1; i >= 0; --i) {
            if (c[i] != '-') {
                sb.insert(0, c[i]);
                count++;
            }
            if (count == K) {
                count = 0;
                sb.insert(0, '-');
            }
        }
        if (sb.length() > 0 && sb.charAt(0) == '-') sb.deleteCharAt(0);
        return sb.toString();
    }
}
