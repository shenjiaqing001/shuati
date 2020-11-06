/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/6
 */
public class lc660 {
    public int newInteger(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int remain = n % 9;
            n /= 9;
            sb.append(remain);
        }
        int res = 0;
        sb = sb.reverse();
        for (int i = 0; i < sb.length(); ++i) {
            res = res * 10 + sb.charAt(i) - '0';
        }
        return res;
    }
}
