/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/21
 */
public class lc392 {
    public boolean isSubsequence(String s, String t) {
        int index1 = 0;
        int index2 = 0;
        char[] cS = s.toCharArray();
        char[] cT = t.toCharArray();
        while (index1 < cS.length && index2 < cT.length) {
            if (cS[index1] == cT[index2]) {
                index1++;
                index2++;
            } else {
                index2++;
            }
        }
        return index1 == cS.length;
    }
}
