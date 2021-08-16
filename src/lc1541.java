/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/8/15
 */
public class lc1541 {
    public int minInsertions(String s) {
        int count = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count < 0) {
                    if (count % 2 == -1) res++;
                    res += ((-count) + 1) / 2;
                    count = 0;
                } else {
                    if (count % 2 == 1) {
                        res++;
                        count--;
                    }
                }
                count += 2;
            } else {
                count -= 1;
            }
        }

        if (count > 0) res += count;
        else {
            if (count % 2 == -1) res++;
            System.out.println(res);
            res += ((-count) + 1) / 2;
        }
        return res;
    }
}
