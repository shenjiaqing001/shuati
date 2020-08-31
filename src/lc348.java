/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/22/20
 */
public class lc348 {
    class TicTacToe {
        int[] X;
        int[] Y;
        int rtlb; // right top to left bot;
        int rblt; // right bot to left top;
        int n;

        /**
         * Initialize your data structure here.
         */
        public TicTacToe(int n) {
            X = new int[n];
            Y = new int[n];
            this.n = n;
        }

        /**
         * Player {player} makes a move at ({row}, {col}).
         *
         * @param row    The row of the board.
         * @param col    The column of the board.
         * @param player The player, can be either 1 or 2.
         * @return The current winning condition, can be either:
         * 0: No one wins.
         * 1: Player 1 wins.
         * 2: Player 2 wins.
         */
        public int move(int row, int col, int player) {
            int flag = 1;
            if (player == 2) flag = -1;
            X[row] += flag;
            Y[col] += flag;
            if (row == col) rtlb += flag;
            if (row + col == n - 1) rblt += flag;
            System.out.println(rtlb + " " + rblt);
            if (X[row] == n || Y[col] == n || rtlb == n ||
                    rblt == n) return 1;
            else if (X[row] == -n || Y[col] == -n || rtlb == -n ||
                    rblt == -n) return 2;
            else return 0;
        }
    }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
}
