import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/25
 */
public class lc753 {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; ++i) sb.append(0);
        int total = (int) Math.pow(k,n);
        Set<String> set = new HashSet<>();
        set.add(sb.toString());

        dfs(sb, set, total, n, k);
        return sb.toString();
    }

    public boolean dfs(StringBuilder sb, Set<String> set, int tota, int n, int k) {
        if (set.size() == tota) return true;
        String str = sb.substring(sb.length() - n + 1);
        for (int c = 0; c < k; ++c) {
            String next = str + c;
            if (set.contains(next)) continue;
            set.add(next);
            sb.append(c);
            if (dfs(sb, set, tota, n, k)) return true;
            sb.deleteCharAt(sb.length() - 1);
            set.remove(next);
        }
        return false;
    }
}
