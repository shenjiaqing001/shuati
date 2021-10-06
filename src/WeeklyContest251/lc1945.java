package WeeklyContest251;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/24
 */
public class lc1945 {
    public int getLucky(String s, int k) {
        int res = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }
        while (k > 0) {
            int ans = 0;
            for (char c : sb.toString().toCharArray()) {
                ans += c - '0';
            }
            // System.out.println(ans);
            sb = new StringBuilder();
            sb.append(ans);
            // System.out.println(sb.toString());
            res = ans;
            k--;
        }
        return res;
    }
}
