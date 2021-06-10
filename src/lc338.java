/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/28
 */
public class lc338 {
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
