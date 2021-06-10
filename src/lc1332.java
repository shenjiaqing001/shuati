/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/3/9
 */
public class lc1332 {
    public int removePalindromeSub(String s) {
        return s.isEmpty() ? 0 : (s.equals(new StringBuilder(s).reverse().toString()) ? 1:2);
    }
}
