/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/4/20
 */
public class lc459 {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }
}
