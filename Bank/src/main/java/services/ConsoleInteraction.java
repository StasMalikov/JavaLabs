package services;

import bank.BankService;
import customer.Customer;
import operatons.OperationsNames;

import java.util.Scanner;

import static java.lang.System.out;

public class ConsoleInteraction {

    private BankService bankService;
    private RandomUsing randomUsing;

    public ConsoleInteraction(BankService bankService){
        this.bankService = bankService;
        this.randomUsing  = new RandomUsing(bankService);
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        out.println("--- Программа Банк ---\n");

        out.println("1 - Работа через консоль");
        out.println("2 - Рандомное создание клиентов и выполнение операций");
        out.println("Выберите режим работы: ");
        int m1 = input.nextInt();

        bankService.startCashierOperators(4);

        if (m1 == 1 ){
            consoleInteraction();
            bankService.stopAll();
        }
        else{
            random();
            bankService.stopAll();
        }


    }

    public void consoleInteraction(){
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        int m1;
        while (flag) {
            out.println("1 - Создать клиента");
            out.println("0 - Выход");
            out.println("Выберите режим работы: ");
            m1 = input.nextInt();

            if(m1 > 0) {
                customerOperations(bankService.newCustomer());
            }else {
                flag = false;
            }
        }
    }

    public void customerOperations(Customer customer) {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        int m1;
        while (flag) {
            out.println("0 - Завершить работу с этим клиентом");
            out.println("1 - Положить деньги");
            out.println("2 - Снять деньги");
            out.println("Выберите операцию: ");
            m1 = input.nextInt();

            switch (m1) {
                case 1:
                {
                    out.println("Введите количество денег: ");
                    int m2 = input.nextInt();
                    customer.setOperation(OperationsNames.PUT, Long.valueOf(m2));
                    break;
                }

                case 2:
                {
                    out.println("Введите количество денег: ");
                    int m2 = input.nextInt();
                    customer.setOperation(OperationsNames.GET, Long.valueOf(m2));
                    break;
                }
                case 0:
                    flag = false;
                    customer.finishCustomerService();
                    break;
            }
        }
    }

    public void random(){
        Scanner input = new Scanner(System.in);
        out.println("Для выхода из этого режима введите 0");
        int m1;
        randomUsing.start();
        while (true){
            m1 = input.nextInt();
            if (m1 == 0){
                //randomUsing.stopRandom();
                randomUsing.interrupt();
                break;
            }
        }


    }
}
