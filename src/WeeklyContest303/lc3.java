package WeeklyContest303;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 7/23/22
 */
public class lc3 {
    class FoodRatings {
        Map<String, TreeSet<String[]>> map = new HashMap<>();
        Map<String, String> foodToCuisine = new HashMap<>();
        Map<String, String> foodToRating = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            int n = foods.length;
            for (String s : cuisines) {
                map.put(s, new TreeSet<>(((o1, o2) -> {
                    int r1 = Integer.parseInt(o1[1]);
                    int r2 = Integer.parseInt(o2[1]);
                    if (r1 == r2) return o1[0].compareTo(o2[0]);
                    else return r2 - r1;
                })));
            }
            for (int i = 0; i < n; ++i) {
                foodToCuisine.put(foods[i], cuisines[i]);
                foodToRating.put(foods[i], String.valueOf(ratings[i]));
                map.get(cuisines[i]).add(new String[]{foods[i], String.valueOf(ratings[i])});
            }
        }

        public void changeRating(String food, int newRating) {
            String c = foodToCuisine.get(food);
            String r = foodToRating.get(food);
            map.get(c).remove(new String[]{food, r});
            foodToRating.put(food, String.valueOf(newRating));
            map.get(c).add(new String[]{food, String.valueOf(newRating)});
        }

        public String highestRated(String cuisine) {
            return map.get(cuisine).first()[0];
        }
    }

}
