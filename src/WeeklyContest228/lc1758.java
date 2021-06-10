package WeeklyContest228;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/2/14
 */
public class lc1758 {
    public int minOperations(String s) {
        int sum1 = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == (i % 2 + '0')) sum1++;
        }
        System.out.println(sum1);
        return Math.min(sum1, s.length() - sum1);
    }
}
