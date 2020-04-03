import logic.InitMatrix;
import logic.MultithreadedMultiplication;
import logic.SingleThreadedMultiplication;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        InitMatrix m = new InitMatrix();

        MultithreadedMultiplication mult = new MultithreadedMultiplication(m.getArr1(), m.getArr2());
        Integer[][] m_res =  mult.multiply();

        SingleThreadedMultiplication single = new SingleThreadedMultiplication();
        Integer[][] s_res = single.multiplicate(m.getArr1(), m.getArr2());



        //   выводит первую матрицу
        //   m.printMatrix(m.getArr1());

        //   выводит вторую матрицу
        //   m.printMatrix(m.getArr2());

        //   выводит результат однопоточного перемножения
        //   m.printMatrix(s_res);

        //   выводит результат многопоточного перемножения
        //   m.printMatrix(m_res);

    }
}
