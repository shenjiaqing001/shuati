import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/16
 */
public class lc678 {
    public boolean checkValidString(String s) {
        List<Character> list = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '*') {
                list.add(c);
            } else {
                if (list.size() == 0) return false;
                int index = list.size() - 1;
                while (index >= 0 && list.get(index) != '(') index--;
                if (index == -1) {
                    list.remove(0);
                } else {
                    list.remove(index);
                }
            }
        }

        int count = 0;
        for (Character c : list) {
            if (c == '(') {
                count++;
            } else {
                if (count > 0) count--;
            }
        }
        return count <= 0;
    }
}
