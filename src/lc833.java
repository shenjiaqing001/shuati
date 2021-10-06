import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/6
 */
public class lc833 {

    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int n = indices.length;
        int[][] sorted = new int[n][2];
        for (int i = 0; i < n; ++i) {
            sorted[i] = new int[]{i, indices[i]};
        }
        Arrays.sort(sorted, (o1, o2) -> (o1[1] - o2[1]));
        int last = 0;
        for (int i = 0; i < n; ++i) {
            int realIndex = sorted[i][0];
            for (int j = last; j < indices[realIndex]; ++j) {
                sb.append(c[j]);
            }
            last = indices[realIndex];

            boolean flag = true;
            char[] tmp = sources[realIndex].toCharArray();
            for (int j = 0; j < tmp.length; ++j) {
                if (indices[realIndex] + j >= c.length || c[indices[realIndex] + j] != tmp[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(targets[realIndex]);
                last = indices[realIndex] + tmp.length;
            }
        }
        for (int i = last; i < c.length; ++i) sb.append(c[i]);
        return sb.toString();
    }
}
