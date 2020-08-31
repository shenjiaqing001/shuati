import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/20/20
 */
public class lc60 {
    public String getPermutation(int n, int k) {
        String res = "";
        List<Integer> remain = new ArrayList<>();
        int tmp = 1;
        for (int i = 1; i <= n; ++i) {
            tmp *= i;
            remain.add(i);
        }

        k -= 1;

        for (int i = n; i >= 1; --i) {
            tmp /= i;
            res += remain.remove(k / tmp);
            k = k % tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        lc60 t = new lc60();
        System.out.println(t.getPermutation(3, 1));

    }

}
