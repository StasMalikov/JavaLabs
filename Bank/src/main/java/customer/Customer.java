package customer;

import operatons.Operation;
import operatons.Operations;
import operatons.OperationsNames;

public class Customer extends Thread {

    private Operations operations;
    private static final int WAITDELAY = 8000;

    Long money;

    public synchronized void addMoney(Long money) {
        this.money += money;
    }

    public Customer(Operations operations){
        super();
        this.operations = operations;
    }

    public void run(){
        setOperation(OperationsNames.PUT, Long.valueOf(1000));
        setOperation(OperationsNames.GET, Long.valueOf(150));
        while (! operations.isServiced(this)){
            try{
                System.out.println("Клиент ожидает обслуживания.");
                Thread.sleep(WAITDELAY);
            }
                catch(InterruptedException e){}
        }
        System.out.println("Клиент обслужен.");
    }

    public void setOperation(OperationsNames operationName, Long money) {
        Operation operation = new Operation(this);
        operation.addOperation(operationName, money);
        operations.addOperation(operation);
    }
}
