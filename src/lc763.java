import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/21/20
 */
public class lc763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] min = new int[26];
        int[] max = new int[26];

        for (int i = 0; i < min.length; ++i) {
            min[i] = -1;
        }


        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            if (min[chars[i] - 'a'] == -1)
                min[chars[i] - 'a'] = i;
            max[chars[i] - 'a'] = i;
        }
        System.out.println(max[0]);

        int now = 0;
        int tmpMax = max[chars[0] - 'a'];
        int last = -1;
        for (int i = 0; i < chars.length; ++i) {
            tmpMax = Math.max(tmpMax, max[chars[i] - 'a']);
            if (tmpMax == i) {
                res.add(now - last);
                last = now;
                tmpMax = now + 1;
            }
        }
        return res;
    }
}
