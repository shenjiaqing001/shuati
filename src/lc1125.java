import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2/1/22
 */
public class lc1125 {

    List<Integer> res = new ArrayList<>();

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> map = new HashMap<>();
        for (String skill : req_skills) {
            map.put(skill, map.size());
        }
        int n = people.size();
        int[] p = new int[n];
        for (int i = 0; i < people.size(); ++i) {
            int hash = 0;
            for (String s : people.get(i)) {
                hash |= (1 << map.get(s));
            }
            p[i] = hash;
        }

        boolean[] flag = new boolean[people.size()];
        for (int i = 0; i < people.size(); ++i) {
            for (int j = i + 1; j < people.size(); ++j) {
                if (i == j) continue;
                int h = p[i] | p[j];
                if (h == p[j]) {
                    flag[i] = true;
                } else if (h == p[i]) {
                    flag[j] = true;
                }
            }
        }


        dfs(p, flag, req_skills.length, new ArrayList<>(), 0);
        int[] t = new int[res.size()];
        for (int i = 0; i < t.length; ++i) {
            t[i] = res.get(i);
        }
        return t;
    }

    public void dfs(int[] people, boolean[] flag, int total, List<Integer> tmp, int state) {
        if (state == (1 << total) - 1) {
            if (res.size() == 0 || res.size() > tmp.size()) {
                res = new ArrayList<>(tmp);
            }
            return;
        }
        if (res.size() != 0 && tmp.size() >= res.size()) return;

        int zero = 0;
        while (((state >> zero) & 1) == 1) {
            zero ++;
        }
        for (int i = 0; i < people.length; i++) {
            if (flag[i]) {
                continue;
            }
            if (((people[i] >> zero) & 1) == 1) {
                // if ((cur | arr[i]) > cur) {
                tmp.add(i);
                dfs(people, flag, total, tmp, state | people[i]);
                tmp.remove(tmp.size() - 1);
            }
        }
    }


}
