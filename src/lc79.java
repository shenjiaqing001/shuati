/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/23/20
 */
public class lc79 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int column = board[0].length;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, 0, i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int i, int j) {
        if (index == word.length() - 1)
            return true;
        char tmp = board[i][j];
        board[i][j] = '.';

        if (i != 0 && board[i - 1][j] == word.charAt(index + 1)) {
            if (dfs(board, word, index + 1, i - 1, j))
                return true;
        }
        if (i != board.length - 1 &&
                board[i + 1][j] == word.charAt(index + 1)) {
            if (dfs(board, word, index + 1, i + 1, j))
                return true;
        }
        if (j != 0 && board[i][j - 1] == word.charAt(index + 1)) {
            if (dfs(board, word, index + 1, i, j - 1))
                return true;
        }
        if (j != board[0].length - 1 &&
                board[i][j + 1] == word.charAt(index + 1)) {
            if (dfs(board, word, index + 1, i, j + 1))
                return true;
        }


        board[i][j] = tmp;
        return false;
    }


    public static void main(String[] args) {
        lc79 t = new lc79();

        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        System.out.println(t.exist(board,word));
    }
}
