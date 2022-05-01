package WeeklyContest289;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 4/16/22
 */
public class lc1 {
    public String digitSum(String s, int k) {
        if(s.length() <= k) return s;
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < c.length; ++i) {
            sum += c[i] - '0';
            count ++;
            if(count == k){
                sb.append(sum);
                sum = 0;
                count = 0;
            }
        }
        if(count > 0) sb.append(sum);
        if(sb.length() <= k) return sb.toString();
        else return digitSum(sb.toString(),k);
    }
}
