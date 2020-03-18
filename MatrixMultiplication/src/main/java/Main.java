import logic.InitMatrix;
import logic.MultithreadedMultiplication;
import logic.SingleThreadedMultiplication;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        InitMatrix m = new InitMatrix();

        MultithreadedMultiplication mult = new MultithreadedMultiplication(m.getArr1(), m.getArr2());
        mult.getResult();
//   выводит результат многопоточного перемножения, тогда верхнюю строчку закоментить m.printMatrix(mult.getResult());
        SingleThreadedMultiplication single = new SingleThreadedMultiplication();
        Integer[][] s_res = single.multiplicate(m.getArr1(), m.getArr2());

//   выводит превую матрицу на консоль     m.printMatrix(m.getArr1());
//   выводит вторую матрицу на консоль     m.printMatrix(m.getArr2());
//        m.printMatrix(s_res);


//    выводит результат однопоточного перемножения   m.printMatrix();

    }
}
