package sudoko2;

public class Row extends sudokuObject implements Runnable{

    Row(int row, int column,int value,int sudoku[][]) {

        super(row, column ,value,sudoku);
    }

    //use to check number in the row or no by return true or false
    @Override
    public void run() {
        int number;
        for (int i = 0; i < SIZE; i++) {
            number = sudoku[row][i];
            if(value == number && i!=column ){
                return;
            }
            else if( value< 1 || value > 9 ){
                return;
            }
        }
        Main.valid[row][column][0]=1;
    }


}
