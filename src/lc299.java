/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/11/20
 */
public class lc299 {
    public String getHint(String secret, String guess) {
        char[] a = secret.toCharArray();
        char[] b = guess.toCharArray();

        int A = 0;
        int B = 0;
        int[] count = new int[10];
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == b[i]) A++;
            else {
                count[a[i] - '0']++;
            }
        }

        for (int i = 0; i < b.length; ++i) {
            if (a[i] != b[i])
                if (count[b[i] - '0'] > 0) {
                    B++;
                    count[b[i] - '0']--;
                }
        }
        return A + "A" + B + "B";
    }
}
