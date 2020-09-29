import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/30
 */
public class lc811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < cpdomains.length; ++i) {
            int times = Integer.valueOf(cpdomains[i].split(" ")[0]);
            String full = cpdomains[i].split(" ")[1];
            map.put(full, map.getOrDefault(full, 0) + times);
            if (full.indexOf('.') != -1) {
                String sub1 = full.substring(full.indexOf('.') + 1);
                System.out.println(sub1);
                map.put(sub1, map.getOrDefault(sub1, 0) + times);
                if (sub1.indexOf('.') != -1) {
                    String sub2 = sub1.substring(sub1.indexOf('.') + 1);
                    System.out.println(sub2);
                    map.put(sub2, map.getOrDefault(sub2, 0) + times);
                }
            }
        }

        for (String kv : map.keySet()) {
            int num = map.get(kv);
            res.add(num + " " + kv);
        }
        return res;
    }
}
