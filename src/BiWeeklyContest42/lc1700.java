package BiWeeklyContest42;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/1/1
 */
public class lc1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        int a1 = 0;
        for (int i = 0; i < students.length; ++i) a1 += students[i];
        int a0 = students.length - a1;
        int index = 0;
        while (index < sandwiches.length) {
            if (sandwiches[index] == 0) {
                if (a0 > 0) a0--;
                else break;
                ;
            } else {
                if (a1 > 0) a1--;
                else break;
            }
            index++;
        }

        return a1 + a0;
    }
}
