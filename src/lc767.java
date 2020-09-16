/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/17/20
 */
public class lc767 {
    public String reorganizeString(String S) {
        char[] str = S.toCharArray();
        int[] c = new int[26];
        for (int i = 0; i < str.length; ++i) {
            c[str[i] - 'a']++;
        }

        int max = 0;
        int maxLetter = 0;
        for (int i = 0; i < 26; ++i) {
            if (c[i] > max) {
                max = c[i];
                maxLetter = i;
            }
        }
        if (max > (str.length + 1) / 2) return "";

        int index = 0;
        while (c[maxLetter] > 0) {
            str[index] = (char) ('a' + maxLetter);
            c[maxLetter]--;
            index += 2;
        }

        for (int i = 0; i < 26; ++i) {
            while (c[i] > 0) {
                if (index >= str.length) index = 1;
                str[index] = (char) ('a' + i);
                c[i]--;
                index += 2;
            }
        }
        return String.valueOf(str);
    }
}
