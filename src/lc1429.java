import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/11/21
 */
public class lc1429 {
    class FirstUnique {

        Set<Integer> notUnique = new HashSet<>();

        // index, value
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        // value , index
        Map<Integer, Integer> indexMap = new HashMap<>();
        int index = 0;

        public FirstUnique(int[] nums) {
            for (int num : nums) {
                if (!notUnique.contains(num)) {
                    if (indexMap.containsKey(num)) {
                        int index = indexMap.get(num);
                        indexMap.remove(num);
                        treeMap.remove(index);
                        notUnique.add(num);
                    } else {
                        treeMap.put(index, num);
                        indexMap.put(num, index);
                        index++;
                    }
                }
            }
        }

        public int showFirstUnique() {
            if (treeMap.isEmpty()) return -1;
            else return treeMap.firstEntry().getValue();
        }

        public void add(int num) {
            if (!notUnique.contains(num)) {
                if (indexMap.containsKey(num)) {
                    int index = indexMap.get(num);
                    indexMap.remove(num);
                    treeMap.remove(index);
                    notUnique.add(num);
                } else {
                    treeMap.put(index, num);
                    indexMap.put(num, index);
                    index++;
                }
            }
        }
    }
}
