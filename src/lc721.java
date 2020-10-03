import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/4
 */
public class lc721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> union = new HashMap<>();
        Map<String, TreeSet<String>> map = new HashMap<>();

        for (List<String> list : accounts) {
            for (int i = 1; i < list.size(); i++) {
                union.put(list.get(i), list.get(i));
                owner.put(list.get(i), list.get(0));
            }
        }

        for (List<String> a : accounts) {
            String p = union(union, a.get(1));
            for (int i = 2; i < a.size(); i++)
                union.put(union(union, a.get(i)), p);
        }
        for (List<String> a : accounts) {
            String p = union(union, a.get(1));
            if (!map.containsKey(p)) map.put(p, new TreeSet<>());
            for (int i = 1; i < a.size(); i++)
                map.get(p).add(a.get(i));
        }
        List<List<String>> res = new ArrayList<>();
        for (String p : map.keySet()) {
            List<String> emails = new ArrayList(map.get(p));
            emails.add(0, owner.get(p));
            res.add(emails);
        }
        return res;
    }


    public String union(Map<String, String> union, String mail) {
        return union.get(mail) == mail ? mail : union(union, union.get(mail));
    }
}
