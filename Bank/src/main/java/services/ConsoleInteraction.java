package services;

import bank.BankService;

import java.util.Scanner;

import static java.lang.System.out;

public class ConsoleInteraction {

    BankService bankService;

    public ConsoleInteraction(BankService bankService){
        this.bankService = bankService;
    }

    public void start() {
        Scanner input = new Scanner(System.in);
        out.println("--- Программа Банк ---\n");

        out.println("1 - Работа через консоль");
        out.println("2 - Рандомное создание клиентов и выполнение операций");
        out.print("Выберите режим работы: ");
        int m1 = input.nextInt();

        if (m1 == 1 ){
            bankService.startCashierOperators(3);
            consoleInteraction();
        }
        else{
            bankService.startCashierOperators(3);
            random();
        }
    }

    public void consoleInteraction(){
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        int m1;
        while (flag) {
            out.println("1 - Создать клиента");
            out.println("0 - Выход");
            out.print("Выберите режим работы: ");
            m1 = input.nextInt();

            if(m1 > 0) {

            }else {
                bankService.stopAll();
                flag = false;
            }

        }
    }

    public void random(){

    }
}
