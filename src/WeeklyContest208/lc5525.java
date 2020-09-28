package WeeklyContest208;

import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/9/27
 */
public class lc5525 {

    class ThroneInheritance {
        Map<String, List<String>> map = new HashMap<>();
        String kingName = "";
        Set<String> death = new HashSet<>();

        public ThroneInheritance(String kingName) {
            this.kingName = kingName;
            map.put(kingName, new ArrayList<>());
        }

        public void birth(String parentName, String childName) {
            map.get(parentName).add(childName);
            map.put(childName, new ArrayList<>());
        }

        public void death(String name) {
            death.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> res = new LinkedList<>();
            dfs(res, kingName);
            return res;
        }

        public void dfs(List<String> res, String name) {
            if (!death.contains(name)) res.add(name);
            for (int i = 0; i < map.get(name).size(); ++i) {
                dfs(res, map.get(name).get(i));
            }
        }
    }
}
