package logic;

import java.io.EOFException;
import java.util.Scanner;
import static java.lang.System.out;

public class InitMatrix {

    private Integer arr1[][];
    private Integer arr2[][];
    private static final int MAXNUMBERINARR = 1000;

    public InitMatrix() throws NullPointerException {
        initArrs();
        initMatrixRandomNumbers();
        printMatrix(arr1);
        printMatrix(arr2);
    }

    private void initArrs() throws NullPointerException {
        Scanner input = new Scanner(System.in);
        out.println("Подсказка: кол-во столбцов 1 массива = кол-во строк 2 массива");

        out.print("Введите количество строк 1 массива:");
        int m1 = input.nextInt();

        out.print("Введите количество столбцов 1 массива:");
        int n1 = input.nextInt();

        out.print("Введите количество строк 2 массива:");
        int m2 = input.nextInt();

        out.print("Введите количество столбцов 2 массива:");
        int n2 = input.nextInt();

        arr1 = new Integer[m1][n1];
        arr2 = new Integer[m2][n2];
        if (n1 != m2) {
            throw new NullPointerException("Неправильно заданы размеры матриц");
        }
    }

    private void initMatrixRandomNumbers() {

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = (int)(Math.random()*MAXNUMBERINARR);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = (int)(Math.random()*MAXNUMBERINARR);
            }
        }
    }

    public void printMatrix(Integer[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                out.print(arr[i][j] + " ");
            }
            out.print("\n");
        }
        out.print("\n");
    }

    public Integer[][] getArr1() {
        return arr1;
    }

    public Integer[][] getArr2() {
        return arr2;
    }
}
