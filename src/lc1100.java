/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/27/20
 */
public class lc1100 {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (K > S.length()) return 0;
        char[] str = S.toCharArray();
        int[] alphabet = new int[256];
        int res = 0;
        int count = 0;

        for (int i = 0; i < K; ++i) {
            if (alphabet[str[i]]++ == 0) {
                count++;
            }
        }
        if (count == K) res++;

        for (int i = K; i < str.length; ++i) {
            if (alphabet[str[i - K]]-- == 1) {
                count--;
            }
            if (alphabet[str[i]]++ == 0) {
                count++;
            }
            if (count == K) res++;
        }

        return res;
    }
}
