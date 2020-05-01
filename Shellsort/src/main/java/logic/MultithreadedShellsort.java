package logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class MultithreadedShellsort {

    private CommonData data;
    private List<MyTread> treads;
    private int treadsCount;

    public MultithreadedShellsort(int arr[]) {
        this.data = new CommonData(arr);
        treads = new ArrayList<>();
        getTreadsCount();
    }

    public int[] sort() throws InterruptedException {

        for(int i = 0; i < this.treadsCount; i++){
            this.treads.add(new MyTread(this.data));
        }

        long m = System.currentTimeMillis();
        for(MyTread t: treads) {
            t.start();
        }

        for(MyTread t: treads) {
            t.join();
        }
        System.out.print((double) (System.currentTimeMillis() - m));
        System.out.print(" милисекунд отработала многопоточная сортировка\n");

        return data.getArr();
    }

    private void getTreadsCount() {
        Scanner input = new Scanner(System.in);
        out.print("Введите количество потоков: ");
        this.treadsCount = input.nextInt();
    }
}
