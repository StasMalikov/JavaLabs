import bank.BankService;
import services.ConsoleInteraction;

public class Main {
    public static void main(String[] args) {
        BankService bs = new BankService();

        ConsoleInteraction ci = new ConsoleInteraction(bs);
        ci.start();
        int i = 0;
    }
}
