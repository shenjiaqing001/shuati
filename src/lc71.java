import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/21/20
 */
public class lc71 {
    public String simplifyPath(String path) {
        String[] str = path.split("/");

        List<String> list = new ArrayList<>();
        for (String s : str) {
            if (s.equals("..")) {
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            } else if (!s.equals(".") && !s.equals("")) {
                list.add(s);
            }
        }

        if (list.size() == 0)
            return "/";

        String res = "";
        for (String s : list) {
            res = res + "/" + s;
        }
        return res;
    }

    public static void main(String[] args) {
        lc71 t = new lc71();
        System.out.println(t.simplifyPath("/a//b////c/d//././/.."));
    }


}
