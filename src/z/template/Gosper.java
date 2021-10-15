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
        int count = 0;
        while (state < (1 << m)) {
            count++;
            // do something to state.
            System.out.println(Integer.toBinaryString(state));
            int c = state & -state;
            int r = state + c;
            state = (((r ^ state) >> 2) / c) | r;
        }
        System.out.println(count);
        return 0;
    }
    //111
    //1011
    //1101
    //1110
    //10011
    //10101
    //10110
    //11001
    //11010
    //11100

    public static void main(String[] args) {
        Gosper(5, 3);
    }
}
