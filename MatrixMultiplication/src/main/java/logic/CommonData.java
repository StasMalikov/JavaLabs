package logic;

public class CommonData {

    private Integer[][] arr1;
    private Integer[][] arr2;
    private Integer[][] result;
    private Integer[] currentCell;
    private static final int I = 0;
    private static final int J = 1;

    /**
     * true -  есть данные для проведения расчётов.
     * false -  нет.
      */
    private boolean haveData;

    public CommonData(Integer[][] arr1, Integer[][] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.result = new Integer[arr1.length][arr2[0].length];
        this.currentCell = new Integer[] {0, -1};
        this.haveData = true;
    }

    public Integer[][] getResult() {
        return this.result;
    }


    public Integer getArr2length() {
        return this.arr2.length;
    }

    public Integer getArr1Value(int index1, int index2) {
        return this.arr1[index1][index2];
    }

    public Integer getArr2Value(int index1, int index2) {
        return this.arr2[index1][index2];
    }

    public boolean haveData() {
        return this.haveData;
    }

    /**
     * Предоставляет индексы ячеек матрицы для потоков.
     * @return null, если массив ячеек закончился.
     */
    public synchronized Integer[] getCurrentCell() {
        if (currentCell[J] + 1 < this.result[currentCell[I]].length) {

            this.currentCell[J]++;
            return new Integer[] {this.currentCell[I],this.currentCell[J]};

        } else if (currentCell[I] + 1 < this.result.length) {

            this.currentCell[I]++;
            this.currentCell[J] = 0;
            return new Integer[] {this.currentCell[I],this.currentCell[J]};

        } else {
            this.haveData = false;
        }

        return null;
    }

    public void setCell(int i, int j, int value) {
        this.result[i][j] = value;
    }
}
