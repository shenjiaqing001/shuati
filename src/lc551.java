/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/21
 */
public class lc551 {
    public boolean checkRecord(String s) {
        boolean countA = false;
        int countL = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                if (countA) return false;
                else countA = true;
                countL = 0;
            } else if (c == 'L') {
                countL++;
                if (countL >= 3) return false;
            } else {
                countL = 0;
            }
        }
        return true;
    }
}
