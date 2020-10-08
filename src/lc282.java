import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/7
 */
public class lc282 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, num, 0, target, 0, 0);
        return res;
    }

    public void dfs(List<String> res, StringBuilder sb, String num, int pos, int target, long now,
                    long multi) {
        if (pos == num.length()) {
            if (now == target) res.add(sb.toString());
            return;
        }

        for (int i = pos; i < num.length(); ++i) {
            if (num.charAt(pos) == '0' && pos != i) break;
            long tmp = Long.valueOf(num.substring(pos, i + 1));
            int length = sb.length();
            if (pos == 0) {
                dfs(res, sb.append(tmp), num, i + 1, target, tmp, tmp);
                sb.setLength(length);
            } else {
                dfs(res, sb.append('+').append(tmp), num, i + 1, target, now + tmp, tmp);
                sb.setLength(length);
                dfs(res, sb.append('-').append(tmp), num, i + 1, target, now - tmp, -tmp);
                sb.setLength(length);
                dfs(res, sb.append('*').append(tmp), num, i + 1, target, now - multi + multi * tmp,
                        multi * tmp);
                sb.setLength(length);
            }
        }
    }
}
