import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/3/21
 */
public class lc869 {
    public boolean reorderedPowerOf2(int N) {
        char[] c = String.valueOf(N).toCharArray();
        Arrays.sort(c);
        String str = String.valueOf(c);

        for (int i = 0; i < 32; ++i) {
            char[] c2 = String.valueOf((int) (1 << i)).toCharArray();
            Arrays.sort(c2);
            String str2 = String.valueOf(c2);
            if (str.equals(str2)) return true;
        }
        return false;
    }
}
