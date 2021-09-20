package z.template;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/9/19
 */
public class Gosper {

    // 枚举 C m选k。
    public static int Gosper(int m, int k) {
        int state = (1 << k) - 1;
        while (state < (1 << m)) {
            // do something to state.
            System.out.println(Integer.toBinaryString(state));
            int c = state & -state;
            int r = state + c;
            state = (((r ^ state) >> 2) / c) | r;
        }

        return 0;
    }

    public static void main(String[] args) {
        Gosper(5, 3);
    }
}
