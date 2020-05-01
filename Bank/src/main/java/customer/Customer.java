package customer;

import operatons.Operation;
import operatons.Operations;
import operatons.OperationsNames;

public class Customer extends Thread {

    private Operations operations;
    private static final int WAITDELAY = 8000;

    private Long money;

    public synchronized void addMoney(Long money) {
        this.money += money;
    }

    public Customer(Operations operations){
        super();
        this.operations = operations;
        this.money = Long.valueOf(0);
    }

    public void run(){
        while (!isInterrupted()){
            try{
                //System.out.println("Клиент ожидает обслуживания.");
                Thread.sleep(WAITDELAY);
            }
                catch(InterruptedException e){
                break;
                }
        }
        System.out.println("Обслуживание клиента " + getName() + "завершено.");
    }

    public void setOperation(OperationsNames operationName, Long money) {
        Operation operation = new Operation(this);
        operation.addOperation(operationName, money);
        operations.addOperation(operation);
        System.out.println("Добавлена операция " + operationName.toString() + " " + money + " " + this.getName());
    }

    public void finishCustomerService() {
        this.interrupt();
    }
}
