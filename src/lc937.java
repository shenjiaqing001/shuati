import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/19/20
 */
public class lc937 {
    public String[] reorderLogFiles(String[] logs) {
        List<String> lit = new ArrayList<>();
        List<String> dig = new ArrayList<>();
        for (int i = 0; i < logs.length; ++i) {
            if (Character.isDigit(logs[i].charAt(logs[i].length() - 1)))
                dig.add(logs[i]);
            else lit.add(logs[i]);
        }

        lit.sort((l1, l2) -> {
            int start1 = l1.indexOf(" ");
            int start2 = l2.indexOf(" ");

            String s1 = l1.substring(start1);
            String s2 = l2.substring(start2);
            int i = s1.compareTo(s2);
            return i == 0 ? l1.substring(0, start1)
                    .compareTo(l2.substring(0, start2)) : i;

        });
        String[] res = new String[logs.length];
        int tmp = 0;
        for (int i = 0; i < lit.size(); ++i) {
            res[tmp++] = lit.get(i);
        }
        for (int i = 0; i < dig.size(); ++i) {
            res[tmp++] = dig.get(i);
        }
        return res;
    }
}
