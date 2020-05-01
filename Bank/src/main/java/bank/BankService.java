package bank;

import customer.Customer;
import operatons.Operations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class BankService {

    private List<CashierOperator> cashierOperators;

    private List<Customer> customers;

    private Operations operations;

    private Bank bank;

    public BankService() {
        cashierOperators = new ArrayList<>();
        customers = new ArrayList<>();
        Long startBankMoney = Long.valueOf(10000);
        bank = new Bank(startBankMoney);
        operations = new Operations();
    }

    public void startCashierOperators(int count) {
        for (int i = 0; i < count; i++) {
            cashierOperators.add(new CashierOperator(operations, bank));
        }

        for (CashierOperator j : cashierOperators) {
            j.start();
        }
    }

    public Customer newCustomer() {
        Customer c = new Customer(operations);
        customers.add(c);
        c.start();
        return c;
    }

    public void stopAll(){
        for(CashierOperator i : cashierOperators){
            i.interrupt();
        }
    }
}
