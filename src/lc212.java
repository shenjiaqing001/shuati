import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/6/29
 */
public class lc212 {

    public class Trie {
        boolean isWord = false;
        Trie[] children = new Trie[26];
        int count = 0;
    }

    List<String> res = new LinkedList<>();

    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        List<int[]> result = new ArrayList<>();
        Trie root = new Trie();
        for (String str : words) {
            Trie trie = root;
            for (char c : str.toCharArray()) {
                if (trie.children[c - 'a'] == null) {
                    trie.children[c - 'a'] = new Trie();
                }
                trie = trie.children[c - 'a'];
                trie.count++;
            }
            trie.isWord = true;
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (root.children[board[i][j] - 'a'] != null &&
                        root.children[board[i][j] - 'a'].count > 0) {
                    dfs(board, visited, root.children[board[i][j] - 'a'], i, j, "" + board[i][j]);
                }
            }
        }

        return res;
    }

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int dfs(char[][] board, boolean[][] visited, Trie root, int x, int y, String str) {
        int count = 0;
        if (root.isWord) {
            root.isWord = false;
            count++;
            res.add(str);
        }
        visited[x][y] = true;

        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx < board.length && ny < board[0].length && nx >= 0 && ny >= 0) {
                if (!visited[nx][ny]) {
                    if (root.children[board[nx][ny] - 'a'] != null &&
                            root.children[board[nx][ny] - 'a'].count > 0) {
                        count += dfs(board, visited, root.children[board[nx][ny] - 'a'], nx, ny,
                                str + board[nx][ny]);
                    }
                }
            }
        }

        visited[x][y] = false;
        root.count -= count;
        return count;
    }
}
