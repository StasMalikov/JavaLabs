package logic;

public class SingleThreadedMultiplication {
    private Integer[][] arr1;
    private Integer[][] arr2;

    public Integer[][] multiplicate(Integer[][] arr1, Integer[][] arr2){

        Integer[][] result = new Integer[arr1.length][arr2[0].length];
        this.arr1 = arr1;
        this.arr2 = arr2;

        long m = System.currentTimeMillis();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = calculateCell(i,j);
            }
        }
        System.out.print((double) (System.currentTimeMillis() - m));
        System.out.print(" милисекунд отработало однопоточное умножение\n");
        return result;
    }

    /**
     *
     * @param row строка 1 массива
     * @param col столбец 2 массива
     * @return ячейка считаемого массива
     */
    private Integer calculateCell(int row, int col) {
        Integer cell = 0;
        for(int i = 0; i < arr2.length; i++) {
            cell += arr1[row][i] * arr2[i][col];
        }
        return cell;
    }

}
