package WeeklyContest301;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/9/22
 */
public class lc3 {
    public boolean canChange(String start, String target) {
        int n = start.length();
        String ss = start.replaceAll("_", "");
        String st = target.replaceAll("_", "");
        if (!ss.equals(st)) return false;
        char[] cs = start.toCharArray();
        char[] ct = target.toCharArray();
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (ct[i] == 'L') count++;
            if (cs[i] == 'L') count--;
            if (count < 0) return false;
        }
         count = 0;
        for (int i = n-1; i >=0; --i) {
            if (ct[i] == 'R') count++;
            if (cs[i] == 'R') count--;
            if (count < 0) return false;
        }
        return true;
    }
}
