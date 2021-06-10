package BiWeeklyContest44;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/23
 */
public class lc1734 {
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int total = 1;
        for (int i = 2; i <= n; ++i) {
            total = total ^ i;
        }

        int[] a = new int[encoded.length];
        a[0] = encoded[0];
        for (int i = 1; i < encoded.length; ++i) {
            a[i] = a[i - 1] ^ encoded[i];
        }

        int total2 = a[0];
        for (int i = 1; i < a.length; ++i) {
            total2 = total2 ^ a[i];
        }

        int[] res = new int[n];
        res[0] = total ^ total2;
        for (int i = 1; i <= encoded.length; ++i) {
            res[i] = res[i - 1] ^ encoded[i - 1];
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
