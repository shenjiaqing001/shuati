/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/15/20
 */
public class lc58 {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;

        String[] strList = s.split(" ");
        if (strList.length == 0) return 0;
        return strList[strList.length - 1].length();
    }
}
