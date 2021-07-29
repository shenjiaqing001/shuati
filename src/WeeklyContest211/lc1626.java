package WeeklyContest211;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2020/10/18
 */
public class lc1626 {
    public class People {
        int score;
        int age;

        People(int score, int age) {
            this.score = score;
            this.age = age;
        }
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        People[] people = new People[scores.length];
        for (int i = 0; i < scores.length; ++i) {
            people[i] = new People(scores[i], ages[i]);
        }
        Arrays.sort(people, new Comparator<>() {
            @Override
            public int compare(People o1, People o2) {
                if (o1.age == o2.age) return o1.score - o2.score;
                return o1.age - o2.age;
            }
        });

        // for (int i = 0; i < people.length; ++i) {
        //     System.out.println(people[i].age + " " + people[i].score);
        // }

        int[] dp = new int[scores.length];
        int max = 0;
        for (int i = 0; i < scores.length; ++i) {
            dp[i] = people[i].score;
            for (int j = 0; j < i; ++j) {
                if (people[i].score >= people[j].score) {
                    dp[i] = Math.max(dp[i], dp[j] + people[i].score);
                }
            }
            max = Math.max(max, dp[i]);
            // System.out.println(dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        lc1626 t = new lc1626();

        System.out.println(t.bestTeamScore(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{811, 364, 124, 873, 790, 656, 581, 446, 885, 134}));
    }
}
