/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/26
 */
public class lc844 {
    public boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();

        int i = s.length - 1;
        int j = t.length - 1;

        int countI = 0;
        int countJ = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0 && countI >= 0) {
                if (s[i] == '#') {
                    countI++;
                    i--;
                } else {
                    if (countI == 0) break;
                    else {
                        countI--;
                        i--;
                    }
                }
            }

            while (j >= 0 && countJ >= 0) {
                if (t[j] == '#') {
                    countJ++;
                    j--;
                } else {
                    if (countJ == 0) break;
                    else {
                        countJ--;
                        j--;
                    }
                }
            }
            if (i == -1 && j == -1) return true;
            if (i == -1 || j == -1) return false;

            if (s[i] == t[j]) {
                i--;
                j--;
            } else return false;
        }

        if (i != -1 || j != -1) return false;
        return true;
    }
}
