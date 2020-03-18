package logic;

public class MyTread extends Thread {
    private CommonData data;

    public MyTread(CommonData data) {
        super();
        this.data = data;
    }

    public void run(){
        Integer result;
        Integer[] cell;
        while(data.haveData()) {
            cell = data.getCurrentCell();
            if (cell != null) {
                result = 0;
                for(int i = 0; i < data.getArr2length(); i++) {
                    result += data.getArr1Value(cell[0], i) * data.getArr2Value(i, cell[1]);
                }
                data.setCell(cell[0], cell[1], result);
            }
        }
    }
}
