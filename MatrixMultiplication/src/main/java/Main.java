import logic.InitMatrix;
import logic.SingleThreadedMultiplication;

public class Main {
    public static void main(String[] args) {
        InitMatrix m = new InitMatrix();
        SingleThreadedMultiplication single = new SingleThreadedMultiplication();
        Integer[][] s_res = single.multiplicate(m.getArr1(), m.getArr2());
        m.printMatrix(s_res);
    }
}
