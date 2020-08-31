import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/12/20
 */
public class lc151 {
    public String reverseWords(String s) {
        s = s.trim();
        String[] strList = s.split(" +");
        Collections.reverse(Arrays.asList(strList));
        return String.join(" ", strList);
    }
}
