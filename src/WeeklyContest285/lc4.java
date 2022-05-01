package WeeklyContest285;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 3/19/22
 */
public class lc4 {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 10000);
        treeMap.put(0, 10000);

        TreeSet<Integer> set = new TreeSet<>();
        char[] cs = s.toCharArray();
        int last = -1;
        int count = 0;
        for (int i = 0; i < cs.length; ++i) {
            if (cs[i] - 'a' != last) {
                set.add(i);
                treeMap.put(count, treeMap.getOrDefault(count, 0) + 1);
                count = 1;
            } else {
                count++;
            }
            last = cs[i] - 'a';
        }
        treeMap.put(count, treeMap.getOrDefault(count, 0) + 1);
        set.add(-1);
        set.add(cs.length);
        int[] res = new int[queryCharacters.length()];
        char[] qcs = queryCharacters.toCharArray();
        for (int i = 0; i < queryCharacters.length(); ++i) {
            int pos = queryIndices[i];
            if (cs.length == 1) {

            } else if (cs[pos] != qcs[i]) {
                if (pos == 0) {
                    if (cs[pos + 1] == cs[pos]) {   //原来一样，现在不一样
                        int next = set.ceiling(pos + 1);
                        treeMap.put(1, treeMap.getOrDefault(1, 0) + 1);
                        int length = next - pos;
                        treeMap.put(length, treeMap.get(length) - 1);
                        if (treeMap.get(length) == 0) treeMap.remove(length);
                        treeMap.put(length - 1, treeMap.getOrDefault(length - 1, 0) + 1);
                        set.add(pos + 1);
                    } else if (cs[pos + 1] == qcs[i]) {    //原来不一样，现在一样
                        int next = set.ceiling(pos + 1);
                        int nextnext = set.ceiling(next + 1);
                        int length = nextnext - next;
                        treeMap.put(length, treeMap.get(length) - 1);
                        if (treeMap.get(length) == 0) treeMap.remove(length);
                        treeMap.put(length + 1, treeMap.getOrDefault(length + 1, 0) + 1);
                        set.remove(pos + 1);
                        set.add(pos);
                    }
                } else if (pos == cs.length - 1) {
                    if (cs[pos - 1] == cs[pos]) {   // 原来一样，现在不一样
                        int index = set.floor(pos - 1);
                        treeMap.put(pos - index + 1, treeMap.get(pos - index + 1) - 1);
                        if (treeMap.get(pos - index + 1) == 0) treeMap.remove(pos - index + 1);
                        treeMap.put(pos - index, treeMap.getOrDefault(pos - index, 0) + 1);
                        treeMap.put(1, treeMap.getOrDefault(1, 0) + 1);
                        set.add(pos);
                    } else if (cs[pos - 1] == qcs[i]) { //原来不一样，现在一样。
                        int index = set.floor(pos - 1);
                        int length = pos - index;
                        set.remove(pos);
                        treeMap.put(length, treeMap.get(length) - 1);
                        if (treeMap.get(length) == 0) treeMap.remove(length);
                        treeMap.put(length + 1, treeMap.getOrDefault(length + 1, 0) + 1);
                    }
                } else {
                    if (cs[pos - 1] == cs[pos] && cs[pos + 1] == cs[pos]) {
                        int index = set.floor(pos - 1);
                        int next = set.ceiling(index + 1);
                        int length = next - index;
                        treeMap.put(length, treeMap.get(length) - 1);
                        if (treeMap.get(length) == 0) treeMap.remove(length);
                        treeMap.put(pos - index, treeMap.getOrDefault(pos - index, 0) + 1);
                        treeMap.put(next - pos - 1, treeMap.getOrDefault(next - pos - 1, 0) + 1);
                        treeMap.put(1, treeMap.getOrDefault(1, 0) + 1);
                        set.add(pos);
                        set.add(pos + 1);
                    } else if (cs[pos - 1] == qcs[i] && cs[pos + 1] == qcs[i]) {
                        int index = set.floor(pos - 1);
                        int next = set.ceiling(pos + 1 + 1);
                        treeMap.put(1, treeMap.get(1) - 1);
                        if (treeMap.get(1) == 0) treeMap.remove(1);
                        treeMap.put(pos - index, treeMap.get(pos - index) - 1);
                        if (treeMap.get(pos - index) == 0) treeMap.remove(pos - index);
                        treeMap.put(next - pos - 1, treeMap.get(next - pos - 1) - 1);
                        if (treeMap.get(next - pos - 1) == 0) treeMap.remove(next - pos - 1);
                        set.remove(pos);
                        set.remove(pos + 1);
                        treeMap.put(next - index, treeMap.getOrDefault(next - index, 0) + 1);
                    } else {
                        if (cs[pos - 1] == cs[pos]) {   // 原来一样，现在不一样
                            int index = set.floor(pos - 1);
                            treeMap.put(pos - index + 1, treeMap.get(pos - index + 1) - 1);
                            if (treeMap.get(pos - index + 1) == 0) treeMap.remove(pos - index + 1);
                            treeMap.put(pos - index, treeMap.getOrDefault(pos - index, 0) + 1);
                            treeMap.put(1, treeMap.getOrDefault(1, 0) + 1);
                            set.add(pos);
                        } else if (cs[pos - 1] == qcs[i]) { //原来不一样，现在一样。
                            int index = set.floor(pos - 1);
                            int length = pos - index;
                            set.remove(pos);
                            treeMap.put(length, treeMap.get(length) - 1);
                            if (treeMap.get(length) == 0) treeMap.remove(length);
                            treeMap.put(length + 1, treeMap.getOrDefault(length + 1, 0) + 1);
                        }

                        if (cs[pos + 1] == cs[pos]) {   //原来一样，现在不一样
                            int next = set.ceiling(pos + 1);
                            treeMap.put(1, treeMap.getOrDefault(1, 0) + 1);
                            int length = next - pos;
                            treeMap.put(length, treeMap.get(length) - 1);
                            if (treeMap.get(length) == 0) treeMap.remove(length);
                            treeMap.put(length - 1, treeMap.getOrDefault(length - 1, 0) + 1);
                            set.add(pos + 1);
                        } else if (cs[pos + 1] == qcs[i]) {    //原来不一样，现在一样
                            int next = set.ceiling(pos + 1);
                            int nextnext = set.ceiling(next + 1);
                            int length = nextnext - next;
                            treeMap.put(length, treeMap.get(length) - 1);
                            if (treeMap.get(length) == 0) treeMap.remove(length);
                            treeMap.put(length + 1, treeMap.getOrDefault(length + 1, 0) + 1);
                            set.remove(pos + 1);
                            set.add(pos);
                        }
                    }
                }
                cs[pos] = qcs[i];
            }
            res[i] = treeMap.lastKey();
        }
        return res;
    }


    public static void main(String[] args) {
        lc4 test = new lc4();
        test.longestRepeating("seeu", "qjcqvsnhq", new int[]{3, 1, 0, 2, 1, 3, 3, 1, 0});
    }
}
