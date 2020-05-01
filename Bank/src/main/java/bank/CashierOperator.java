package bank;

import operatons.Operation;
import operatons.Operations;
import operatons.OperationsNames;
import java.util.Iterator;
import java.util.Map;

/**
 * Операционистка.
 */
public class CashierOperator extends Thread {

    private Operations operations;
    private Bank bank;
    private static final int NOOPERATIONSDELAY = 5000;
    private static final int GETOPERATIONDELAY = 7000;
    private static final int PUTOPERATIONDELAY = 2000;

    public CashierOperator(Operations operations, Bank bank) {
        super();
        this.bank = bank;
        this.operations = operations;
    }

    public void run() {
        while (!isInterrupted()) {
            try {
                Operation operation = operations.getOpenOperation();

                if (operation != null) {
                    doOperations(operation);
                    operations.closeOperation(operation);
                } else {
                    //System.out.println("Операционистка бездействует.");
                    Thread.sleep(NOOPERATIONSDELAY);
                }
            } catch (InterruptedException e) {
                System.out.println("Операционистка " + getName() + " закончила работу.");
                break;
            }
        }
    }

    public void doOperations(Operation operation) {
        Iterator it = operation.getOperations().entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            switch ((OperationsNames) pair.getKey()){
                case GET:
                    get((Long) pair.getValue(), operation);
                    break;
                case PUT:
                    put((Long) pair.getValue(), operation);
                    break;
            }
        }
    }

    public void get(Long money, Operation operation){
        try{
            Thread.sleep(GETOPERATIONDELAY);
            Long returnedMoney = bank.getMoney(money);
            if (returnedMoney > 0) {
                operation.addMoney(returnedMoney);
                System.out.println("Деньги в размере " + money + " успешно получены");
            } else {
                System.out.println("Ошибка! Банк не может выдать " + money);
            }
        }
        catch(InterruptedException e){
            operations.rollback(operation);
            System.out.println("Операция GET прервана " + this.getName());
            this.interrupt();
        }
    }

    public void put(Long money, Operation operation) {
        try{
            Thread.sleep(PUTOPERATIONDELAY);
            int putOperationResult = bank.putMoney(money);
            if (putOperationResult > 0) {
                System.out.println("Деньги в размере " + money + " успешно положены в банк");
            } else {
                System.out.println("Ошибка! Вы попытались положить " + money + " денег");
            }
        }
        catch(InterruptedException e){
            operations.rollback(operation);
            System.out.println("Операция PUT прервана" + this.getName());
            this.interrupt();
        }
    }
}
