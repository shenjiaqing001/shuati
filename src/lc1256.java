/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 1/27/22
 */
public class lc1256 {
    public String encode(int num) {
        return Integer.toString(++num, 2).substring(1);
    }
}
