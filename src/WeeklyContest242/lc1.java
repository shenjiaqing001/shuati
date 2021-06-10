package WeeklyContest242;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/22
 */
public class lc1 {
    public boolean checkZeroOnes(String s) {
        int[] count = new int[2];
        char c = s.charAt(0);
        int tmp = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                tmp++;
            } else {
                count[c - '0'] = Math.max(count[c - '0'], tmp);
                tmp = 1;
                c = s.charAt(i);
            }
        }
        count[c - '0'] = Math.max(count[c - '0'], tmp);
        return count[1] > count[0];
    }
}
