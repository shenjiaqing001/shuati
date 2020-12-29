import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/12/19
 */
public class lc1233 {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();
        for (String f : folder) {
            if (res.isEmpty() || !f.startsWith(res.get(res.size() - 1) + "/"))
                res.add(f);
        }
        return res;
    }
}
