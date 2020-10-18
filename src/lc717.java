/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/17
 */
public class lc717 {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        for (i = 0; i < bits.length - 1; i++) {
            if (bits[i] != 0) i++;
        }
        return i == bits.length - 1;
    }
}
