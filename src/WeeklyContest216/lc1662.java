package WeeklyContest216;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/11/26
 */
public class lc1662 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int n = 0;
        int m = 0;
        int i = 0;
        int j = 0;
        while (true) {
            //System.out.println(n + " " + i + " --- " + m + " " + j);
            if (i == word1[n].length()) {
                i = 0;
                n++;
            }
            if (j == word2[m].length()) {
                j = 0;
                m++;
            }
            if (n == word1.length && m == word2.length) break;
            if (n == word1.length || m == word2.length) return false;
            if (word1[n].charAt(i++) != word2[m].charAt(j++)) return false;
        }
        return true;
    }
}
