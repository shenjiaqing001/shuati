import java.util.Arrays;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/19/20
 */
public class lc824 {
    public String toGoatLatin(String S) {
        int count = 1;
        String[] list = S.split(" ");
        String res = "";
        for (int i = 0; i < list.length; ++i) {
            char begin = list[i].toLowerCase().charAt(0);
            if (!(begin == 'a' || begin == 'e' || begin == 'i' ||
                    begin == 'o' || begin == 'u')) {
                res += list[i].substring(1) + list[i].charAt(0) + "ma";
            } else
                res += list[i] + "ma";
            for (int j = 0; j < count; ++j)
                res += "a";
            res += " ";
            count++;
        }

        return res.substring(0, res.length() - 1);
    }

}
