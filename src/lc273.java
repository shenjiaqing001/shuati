/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 8/28/20
 */
public class lc273 {
    private final String[] LESS_THAN_20 =
            {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS =
            {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};


    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int i = 0;
        String res = "";
        while (num > 0) {
            int last = num % 1000;
            if (last != 0)
                res = helper(last) + THOUSANDS[i] + " " + res;
            num /= 1000;
            i++;
        }
        return res.strip();
    }


    public String helper(int num) {
        if (num == 0) return "";
        if (num < 20) return LESS_THAN_20[num] + " ";
        if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        }
        return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }
}
