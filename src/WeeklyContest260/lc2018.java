package WeeklyContest260;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/25
 */
public class lc2018 {
    public static void main(String[] args) {
        lc2018 test = new lc2018();
        test.placeWordInCrossword(new char[][]{{'#', ' ', '#'}, {' ', ' ', '#'}, {'#', 'c', ' '}},
                "abc");


    }

    public boolean placeWordInCrossword(char[][] board, String word) {
        char[] c = word.toCharArray();
        int n = word.length();

        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '#') continue;
                for (int[] dir : dirs) {
                    int px = i + dir[0];
                    int py = j + dir[1];
                    if (px < 0 || py < 0 || px >= board.length || py >= board[0].length ||
                            board[px][py] == '#') {
                        int index = 0;
                        while (true) {
                            int nx = i - dir[0] * index;
                            int ny = j - dir[1] * index;
                            if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) {
                                if (index == n) return true;
                                break;
                            }
                            if (board[nx][ny] == '#') {
                                if (index == n) return true;
                                break;
                            }
                            if (index == n) break;
                            if (board[nx][ny] == ' ' || board[nx][ny] == c[index]) {
                                index++;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
