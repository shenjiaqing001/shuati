package WeeklyContest239;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/5/1
 */
public class lc1850 {
    public int getMinSwaps(String num, int k) {
        int[] nums = new int[num.length()];
        for (int i = 0; i < num.length(); ++i) {
            nums[i] = num.charAt(i) - '0';
        }
        for (int i = 0; i < k; ++i) {
            nextPermutation(nums);
        }
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i]);
        }
        char[] c = num.toCharArray();
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != c[i] - '0') {
                int index = i + 1;
                for (; index < nums.length; ++index) {
                    if (nums[i] == c[index] - '0') break;
                }
                System.out.println(i + " " + index);
                res += index - i;
                char tmp = c[index];
                for (int j = index; j > i; --j) {
                    c[j] = c[j - 1];
                }
                c[i] = tmp;
                for (int j = 0; j < nums.length; ++j) {
                    System.out.print(c[j]);
                }
                System.out.println();
            }
        }
        return res;
    }


    public void nextPermutation(int[] num) {
        int n = num.length;
        if (n < 2)
            return;
        int index = n - 1;
        while (index > 0) {
            if (num[index - 1] < num[index])
                break;
            index--;
        }
        if (index == 0) {
            reverseSort(num, 0, n - 1);
            return;
        } else {
            int val = num[index - 1];
            int j = n - 1;
            while (j >= index) {
                if (num[j] > val)
                    break;
                j--;
            }
            swap(num, j, index - 1);
            reverseSort(num, index, n - 1);
            return;
        }
    }

    public void swap(int[] num, int i, int j) {
        int temp = 0;
        temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public void reverseSort(int[] num, int start, int end) {
        if (start > end)
            return;
        for (int i = start; i <= (end + start) / 2; i++)
            swap(num, i, start + end - i);
    }
}
