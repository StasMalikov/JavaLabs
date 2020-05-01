package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class MultithreadedMultiplication {
    private List<MyTread> treads;
    private CommonData commonData;

    private int treadsCount;

    public MultithreadedMultiplication(Integer[][] arr1, Integer[][] arr2) {
        treads = new ArrayList<>();
        commonData = new CommonData(arr1, arr2);
        getTreadsCount();
    }

    public Integer[][] multiply() throws InterruptedException {

        for(int i = 0; i < this.treadsCount; i++){
            this.treads.add(new MyTread(this.commonData));
        }

        long m = System.currentTimeMillis();

        for(MyTread t: treads) {
            t.start();
        }

        for(MyTread t: treads) {
            t.join();
        }

        System.out.print((double) (System.currentTimeMillis() - m));
        System.out.print(" милисекунд отработало многопоточное умножение\n");

        return commonData.getResult();
    }

    private void getTreadsCount() {
        Scanner input = new Scanner(System.in);
        out.print("Введите количество потоков: ");
        this.treadsCount = input.nextInt();
    }
}
