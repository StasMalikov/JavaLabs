package operatons;

import customer.Customer;

import java.util.HashMap;
import java.util.Map;

public class Operation {
    private Customer customer;
    Map<OperationsNames, Long> operations;

    public Customer getCustomer() {
        return customer;
    }

    public Operation(Customer customer) {
        this.customer = customer;
        operations = new HashMap<>();
    }

    public void addMoney(Long money) {
         customer.addMoney(money);
    }

    public Map<OperationsNames, Long> getOperations() {
        return operations;
    }

    public void addOperation(OperationsNames name, Long money) {
        this.operations.put(name, money);
    }

}
