import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/18
 */
public class lc51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new LinkedList<>();
        char[][] map = new char[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                map[i][j] = '.';
        dfs(0, map, res);
        return res;
    }

    public void dfs(int level, char[][] map, List<List<String>> res) {
        if (level == map.length) {
            generateAns(map, res);
            return;
        }
        for (int i = 0; i < map.length; ++i) {
            if (check(level, i, map)) {
                map[level][i] = 'Q';
                dfs(level + 1, map, res);
                map[level][i] = '.';
            }
        }
    }

    public boolean check(int level, int index, char[][] map) {
        for (int i = 0; i < level; ++i) {
            for (int j = 0; j < map.length; ++j) {
                if (map[i][j] == 'Q') {
                    if (j == index) return false;
                    if (index == j + (level - i) || index == j - (level - i)) return false;
                }
            }
        }
        return true;
    }

    public void generateAns(char[][] map, List<List<String>> res) {
        List<String> ans = new LinkedList<>();
        for (char[] c : map) {
            ans.add(String.valueOf(c));
        }
        res.add(ans);
    }
}
