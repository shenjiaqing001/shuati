/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/22
 */
public class lc838 {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder(dominoes);
        int L = -1;
        int R = -1;
        for (int i = 0; i < sb.length(); ++i) {
            if (i == sb.length() || sb.charAt(i) == 'R') {
                if (R > L) while (R < i) sb.setCharAt(R++, 'R');
                R = i;
            } else if (sb.charAt(i) == 'L') {
                if (L > R || R == -1) {
                    while (++L < i) sb.setCharAt(L, 'L');
                } else {
                    L = i;
                    for (int lo = R + 1, hi = L - 1; lo < hi; ) {
                        sb.setCharAt(lo++, 'R');
                        sb.setCharAt(hi--, 'L');
                    }
                }

            }
        }
        return sb.toString();
    }
}
