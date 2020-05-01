package services;

import bank.BankService;
import customer.Customer;
import operatons.OperationsNames;

public class RandomUsing extends Thread{

    private boolean stop;
    private BankService bankService;
    private static final int DELAY = 1700;

    public RandomUsing(BankService bankService) {
        stop = false;
        this.bankService = bankService;
    }

    public void stopRandom(){
        stop = true;
    }

    public void run() {

        Customer c1 = bankService.newCustomer();
        Customer c2 = bankService.newCustomer();
        Customer c3 = bankService.newCustomer();
        Customer c4 = bankService.newCustomer();

        while (!isInterrupted()) {
            try{
                int randomCustomer = (int)(Math.random()*4);
                int randomMoney = (int)(Math.random()*500);
                int randomAction = (int)(Math.random()*2);
                switch (randomAction) {
                    case 0:{
                        switch (randomCustomer) {
                            case 0:
                            {
                                c1.setOperation(OperationsNames.GET, Long.valueOf(randomMoney));
                                break;
                            }
                            case 1:
                            {
                                c2.setOperation(OperationsNames.GET, Long.valueOf(randomMoney));
                                break;
                            }
                            case 2:
                            {
                                c3.setOperation(OperationsNames.GET, Long.valueOf(randomMoney));
                                break;
                            }
                            case 3:
                            {
                                c4.setOperation(OperationsNames.GET, Long.valueOf(randomMoney));
                                break;
                            }
                        }
                        break;
                    }
                    case 1:{
                        switch (randomCustomer) {
                            case 0:
                            {
                                c1.setOperation(OperationsNames.PUT, Long.valueOf(randomMoney));
                                break;
                            }
                            case 1:
                            {
                                c2.setOperation(OperationsNames.PUT, Long.valueOf(randomMoney));
                                break;
                            }
                            case 2:
                            {
                                c3.setOperation(OperationsNames.PUT, Long.valueOf(randomMoney));
                                break;
                            }
                            case 3:
                            {
                                c4.setOperation(OperationsNames.PUT, Long.valueOf(randomMoney));
                                break;
                            }
                        }
                        break;
                    }
                }
                sleep(DELAY);
            }catch (InterruptedException e ) {
                stop = true;
                c1.finishCustomerService();
                c2.finishCustomerService();
                c3.finishCustomerService();
                c4.finishCustomerService();
                break;
            }
        }
    }
}
