import java.util.*;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/7/17
 */
public class lc18 {

    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);

        Map<Integer, List<int[]>> twoSumMap =
                new HashMap<>(); // for holding visited pair sums. All pairs with the same pair sum are grouped together
        Set<List<Integer>> res = new HashSet<>();  // for holding the results

        for (int i = 0; i < num.length; i++) {
            // get rid of repeated pair sums
            if (i > 1 && num[i] == num[i - 2]) continue;

            for (int j = i + 1; j < num.length; j++) {
                // get rid of repeated pair sums
                if (j > i + 2 && num[j] == num[j - 2]) continue;

                // for each pair sum, check if the pair sum that is needed to get the target has been visited.
                if (twoSumMap.containsKey(target - (num[i] + num[j]))) {
                    // if so, get all the pairs that contribute to this visited pair sum.
                    List<int[]> ls = twoSumMap.get(target - (num[i] + num[j]));

                    for (int[] pair : ls) {
                        // we have two pairs: one is indicated as (pair[0], pair[1]), the other is (i, j).
                        // we first need to check if they are overlapping with each other.
                        int m1 = Math.min(pair[0], i);  // m1 will always be the smallest index
                        int m2 = Math.min(pair[1], j);  // m2 will be one of the middle two indices
                        int m3 = Math.max(pair[0], i);  // m3 will be one of the middle two indices
                        int m4 = Math.max(pair[1], j);  // m4 will always be the largest index

                        if (m1 == m3 || m1 == m4 || m2 == m3 || m2 == m4)
                            continue;  // two pairs are overlapping, so just ignore this case

                        res.add(Arrays.asList(num[m1], num[Math.min(m2, m3)], num[Math.max(m2, m3)],
                                num[m4]));  // else record the result
                    }
                }

                // mark that we have visited current pair and add it to the corrsponding pair sum group.
                // here we've encoded the pair indices i and j into an integer array of length 2.
                twoSumMap.computeIfAbsent(num[i] + num[j], key -> new ArrayList<>())
                        .add(new int[]{i, j});
            }
        }

        return new ArrayList<List<Integer>>(res);
    }


    class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return this.x + " - " + this.y;
        }
    }

    public List<List<Integer>> fourSum2(int[] nums, int target) {
        HashMap<Integer, List<Pair>> map = new HashMap<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // if (i != 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                int sum = nums[i] + nums[j];
                Pair p = new Pair(i, j);
                map.putIfAbsent(sum, new ArrayList<>());
                map.get(sum).add(p);
            }
        }


        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;

                int sum = nums[i] + nums[j];
                if (map.containsKey(target - sum)) {
                    List<Pair> pairs = map.get(target - sum);
                    for (Pair pair : pairs) {
                        int x = pair.x;
                        int y = pair.y;
                        if (i < x && j < x) {
                            if (x != j + 1 && nums[x] == nums[x - 1]) continue;
                            List<Integer> tmp = new ArrayList<>();
                            tmp.add(nums[i]);
                            tmp.add(nums[j]);
                            tmp.add(nums[x]);
                            tmp.add(nums[y]);
                            res.add(tmp);
                        }
                    }
                }
            }
        }
        return res;
    }
}
