package bank;

public class Bank {
    private Long money;

    public Bank(Long money) {
        this.money = money;
    }

    /**
     * @return  >0 - successful operation
     * @return 0 - failed operation
     */
    public synchronized Long getMoney(Long money) {
        if (money > 0) {
            if (money > this.money) {
                return Long.valueOf(0);
            }
            this.money -= money;
            return money;
        }
        return Long.valueOf(0);
    }

    /**
     * @return 1 - successful operation
     * @return 0 - failed operation
     */
    public synchronized int putMoney(Long money) {
        if (money > 0) {
            this.money += money;
            return 1;
        }
        return 0;
    }
}

