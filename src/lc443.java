import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 9/4/20
 */
public class lc443 {
    public int compress(char[] chars) {
        int now;
        int tmp = 0;
        int count = 1;
        for (now = 1; now <= chars.length; ++now) {
            if (now < chars.length && chars[now] == chars[now - 1]) {
                count++;
            } else {
                chars[tmp] = chars[now - 1];
                tmp++;
                if (count > 1) {
                    List<Integer> numList = new LinkedList<>();
                    while (count > 0) {
                        numList.add(0, count % 10);
                        count /= 10;
                    }
                    for (Integer i : numList)
                        chars[tmp++] = (char) ('0' + i);
                }
                count = 1;
            }
        }

        return tmp;
    }
}
