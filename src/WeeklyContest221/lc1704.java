package WeeklyContest221;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/27
 */
public class lc1704 {
    public boolean halvesAreAlike(String s) {
        char[] c = s.toLowerCase().toCharArray();
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n / 2; ++i) {
            if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') count++;
        }
        for (int i = n / 2; i < n; ++i) {
            if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') count--;
        }
        return count == 0 ? true : false;
    }
}
