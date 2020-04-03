import logic.ArrayGenerator;
import logic.MultithreadedShellsort;
import logic.Shellsort;

import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        out.println("Подсказка: 0 - выход");

        out.print("Введите длинну массива:");
        int size = input.nextInt();

        ArrayGenerator g = new ArrayGenerator();
        int arr[] = g.genereteArr(size);

        Shellsort s = new Shellsort();

        int result1[] = s.sort(arr);

        MultithreadedShellsort ms = new MultithreadedShellsort(arr);
        int result2[] = ms.sort();


        // исходный массив
        //printArr(arr);

        // однопоточная сортировка
        //printArr(result1);

        // многопоточная сортировка
        //printArr(result2);
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            System.out.print(' ');
        }
        System.out.print('\n');
    }
}
