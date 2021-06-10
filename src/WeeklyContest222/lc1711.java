package WeeklyContest222;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/3
 */
public class lc1711 {
    public int countPairs(int[] deliciousness) {
        int[] delicious = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192,
                16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608,
                16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824,};

        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < deliciousness.length; ++i) {
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], (long) 0) + 1);
        }

        long one = 0;
        long two = 0;
        for (Integer key : map.keySet()) {
            for (int i = 0; i < delicious.length; ++i) {
                if (map.containsKey(delicious[i] - key)) {
                    int key2 = delicious[i] - key;
                    System.out.println(key + " " + key2);
                    System.out.println(map.get(key) + " " + map.get(key2));
                    if (key == key2) {
                        long plus = (map.get(key) * (map.get(key) - 1) / 2) % 1000000007;
                        one = (one + plus) % 1000000007;
                    } else {
                        long plus = map.get(key) * map.get(key2) % 1000000007;
                        two = (two + plus) % 1000000007;
                    }
                }
            }
        }
        two /= 2;
        return (int) ((one + two) % 1000000007);
    }

    public static void main(String[] args) {
        int pow = 2;
        for (int i = 0; i < 32; ++i) {
            System.out.println(pow + ",");
            pow *= 2;
        }
    }
}
