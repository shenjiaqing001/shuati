package WeeklyContest321;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 11/26/22
 */
public class lc2 {
    public int appendCharacters(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int index1 = 0;
        int index2 = 0;
        while (index1 < c1.length && index2 < c2.length) {
            if (c1[index1] == c2[index2]) {
                index2 += 1;
            }
            index1 += 1;
        }
        return t.length() - index2;
    }
}
