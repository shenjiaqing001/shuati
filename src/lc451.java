import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/18
 */
public class lc451 {
    public String frequencySort(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int[][] arr = new int[128][2];
        for (int i = 0; i < 128; ++i) {
            arr[i][0] = i;
            arr[i][1] = count[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> -o[1]));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; ++i) {
            for (int j = 0; j < arr[i][1]; ++j) {
                sb.append((char) arr[i][0]);
            }
        }
        return sb.toString();
    }
}
