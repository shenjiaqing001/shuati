/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/24
 */
public class lc794 {
    public boolean validTicTacToe(String[] board) {
        int x = 0;
        int[] row = new int[3];
        int[] col = new int[3];
        int d = 0;
        int dv = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i].charAt(j) == 'X') {
                    x++;
                    row[i]++;
                    col[j]++;
                    if (i == j) d++;
                    if (i == 2 - j) dv++;
                } else if (board[i].charAt(j) == 'O') {
                    x--;
                    row[i]--;
                    col[j]--;
                    if (i == j) d--;
                    if (i == 2 - j) dv--;
                }
            }
        }

        boolean xwin = row[0] == 3 || row[1] == 3 || row[2] == 3 ||
                col[0] == 3 || col[1] == 3 || col[2] == 3 ||
                d == 3 || dv == 3;
        boolean owin = row[0] == -3 || row[1] == -3 || row[2] == -3 ||
                col[0] == -3 || col[1] == -3 || col[2] == -3 ||
                d == -3 || dv == -3;

        System.out.println(xwin + " " + owin);

        if (x != 0 && x != 1) return false;
        if (xwin && x == 0 || owin && x == 1) {
            return false;
        }
        if (xwin && owin) return false;

        return true;
    }
}
