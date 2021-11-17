package WeeklyContest266;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/6
 */
public class lc2063 {
    public long countVowels(String word) {
        long res = 0;
        char[] c = word.toCharArray();
        int n = word.length();
        for (int i = 0; i < c.length; ++i) {
            if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') {
                res += (long) (i + 1) * (n - i);
            }
        }

        return res;
    }
}
