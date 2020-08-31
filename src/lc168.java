/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/16/20
 */
public class lc168 {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            sb.insert(0, (char) ('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }
        return sb.toString();
    }
}
