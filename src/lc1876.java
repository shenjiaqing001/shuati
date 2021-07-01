/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/1
 */
public class lc1876 {
    public int countGoodSubstrings(String s) {
        int res = 0;
        int distinct = 1;
        int[] count = new int[26];
        if (s.length() < 3) return 0;
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; ++i) {
            count[c[i] - 'a']++;
            if (count[c[i] - 'a'] == 1) distinct++;

            if (i > 3) {
                count[c[i - 3] - 'a']--;
                if (count[c[i - 3] - 'a'] == 0) distinct--;
            }
            System.out.println(i + " " + distinct);
            if (distinct == 3) res++;
        }

        return res;
    }
}
