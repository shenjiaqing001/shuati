package OnlineAssessment.CodeSignal;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/25
 */
public class q2 {

    public boolean[] solve(String[] strings, String[] sources) {
        int n = sources.length;
        boolean[] res = new boolean[n];
        char[] c = new char[500 + 5];
        Set<Integer> set = new HashSet<>();
        int index = 0;
        for (String s : strings) {
            for (char sc : s.toCharArray()) {
                c[index++] = sc;
            }
            set.add(index);
            if (index > 100) break;
        }

        for (int i = 0; i < sources.length; ++i) {
            char[] sc = sources[i].toCharArray();
            int j = 0;
            while (j < sc.length && sc[j] == c[j]) {
                j++;
            }
            if (j == sc.length && set.contains(j)) {
                res[i] = true;
            }
        }
        return res;
    }

}
