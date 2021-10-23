package WeeklyContest263;

/**
 * @author Jiaqing Shen
 * @description
 * @date Created in 2021/10/16
 */
public class lc2043 {
    class Bank {
        long[] balance;
        int n;

        public Bank(long[] balance) {
            this.balance = balance;
            n = balance.length - 1;
        }

        public boolean transfer(int account1, int account2, long money) {
            account1 -= 1;
            account2 -= 1;
            if (account1 > n || account2 > n) return false;
            if (balance[account1] < money) return false;
            balance[account1] -= money;
            balance[account2] += money;
            return true;
        }

        public boolean deposit(int account, long money) {
            account -= 1;
            if (account > n) return false;
            balance[account] += money;
            return true;
        }

        public boolean withdraw(int account, long money) {
            account -= 1;
            if (account > n) return false;
            if (balance[account] < money) return false;
            balance[account] -= money;
            return true;
        }
    }
}
