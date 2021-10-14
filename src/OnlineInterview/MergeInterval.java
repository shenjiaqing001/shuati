package OnlineInterview;

import java.util.TreeMap;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/12
 */
public class MergeInterval {

    TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) {
        MergeInterval test = new MergeInterval();
        test.insert(1, 4);
        test.insert(5, 8);
        test.insert(2, 6);
        System.out.println();
    }

    public void insert(int start, int end) {
        Integer floorKey = treeMap.floorKey(start);
        int oriStart = start;
        if (floorKey != null && treeMap.get(floorKey) >= start) {
            oriStart = floorKey;
            end = Math.max(end, treeMap.get(floorKey));
        }
        while (treeMap.ceilingKey(start + 1) != null && treeMap.ceilingKey(start + 1) <= end) {
            start = treeMap.ceilingKey(start + 1);
            end = Math.max(end, treeMap.get(start));
            treeMap.remove(start);
        }
        treeMap.put(oriStart, end);
    }

}
