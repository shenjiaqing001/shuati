import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/25
 */
public class lc247 {

    // 1 0 8, 6 9
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        char[] c = new char[n];

        dfs(res, c, n, (n - 1) / 2);

        return res;
    }

    public void dfs(List<String> res, char[] c, int n, int index) {
        if (index == -1) {
            res.add(new String(c));
            return;
        }
        if (n % 2 == 1 && index == n / 2) {
            c[index] = '0';
            dfs(res, c, n, index - 1);
            c[index] = '1';
            dfs(res, c, n, index - 1);
            c[index] = '8';
            dfs(res, c, n, index - 1);
        } else {
            if (index != 0) {
                c[index] = '0';
                c[n - 1 - index] = '0';
                dfs(res, c, n, index - 1);
            }
            c[index] = '1';
            c[n - 1 - index] = '1';
            dfs(res, c, n, index - 1);
            c[index] = '6';
            c[n - 1 - index] = '9';
            dfs(res, c, n, index - 1);
            c[index] = '8';
            c[n - 1 - index] = '8';
            dfs(res, c, n, index - 1);
            c[index] = '9';
            c[n - 1 - index] = '6';
            dfs(res, c, n, index - 1);
        }
    }

    public static void main(String[] args) {
        char[] c = new char[5];
        c[4] = '1';
        System.out.println(new String(c));
    }
}
