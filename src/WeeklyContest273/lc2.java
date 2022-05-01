package WeeklyContest273;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 12/25/21
 */
public class lc2 {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] res = new int[s.length()];
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; ++i) {
            int x = startPos[0];
            int y = startPos[1];
            int j = 0;
            while (i + j < c.length) {
                if (c[i + j] == 'U') x -= 1;
                if (c[i + j] == 'D') x += 1;
                if (c[i + j] == 'L') y -= 1;
                if (c[i + j] == 'R') y += 1;

                if (x < 0 || x >= n || y < 0 || y >= n) break;
                j++;
            }
            res[i] = j;
        }
        return res;
    }
}
