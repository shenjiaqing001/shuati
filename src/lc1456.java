/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/11
 */
public class lc1456 {
    public int maxVowels(String s, int k) {
        int count = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < k; ++i) {
            if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') count++;
        }
        int max = count;
        for (int i = k; i < c.length; ++i) {
            if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') count++;
            if (c[i - k] == 'a' || c[i - k] == 'e' || c[i - k] == 'i' || c[i - k] == 'o' ||
                    c[i - k] == 'u') count--;
            max = Math.max(max, count);
        }

        return max;
    }
}
