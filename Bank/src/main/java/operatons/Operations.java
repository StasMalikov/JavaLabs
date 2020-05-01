package operatons;

import customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class Operations {
    List<Operation> operations;
    List<Operation> processingOperations;
    List<Operation> closedOperations;

    public Operations() {
        operations = new ArrayList<>();
        processingOperations = new ArrayList<>();
        closedOperations = new ArrayList<>();
    }

    public synchronized Operation getOpenOperation() {
        if (operations.size() > 0) {
            Operation o = operations.remove(operations.size() - 1);
            processingOperations.add(o);
            return o;
        }
        return null;
    }

    public synchronized void addOperation(Operation operation) {
        if (operation != null)
            this.operations.add(operation);
    }

    public synchronized void closeOperation(Operation operation){
        closedOperations.add(operation);
    }

    public synchronized boolean isServiced(Customer customer) {
        int check = 0;
        for (Operation o : operations) {
            if (customer.equals(o.getCustomer()))
                check++;
        }

        for (Operation o : processingOperations) {
            if (customer.equals(o.getCustomer()))
                check++;
        }

        return check > 0 ?  false : true;
    }
}
