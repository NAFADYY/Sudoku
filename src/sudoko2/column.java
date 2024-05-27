package sudoko2;

public class column extends sudokuObject implements Runnable{
    column(int row, int column, int value,int [][]sudoku) {
        super(row, column, value,sudoku );
    }

    @Override
    public void run() {
        int number;
        for (int i = 0; i < SIZE; i++) {
            number = sudoku[i][column];
            //System.out.print(number);
            if (number>1 &&number<=9){
            if(value == number && i!=row){
                return;
            }
            else if( value < 1 || value > 9 ){

                return;
            }
        }
        Main.valid[row][column][1]=1;
        }

}
}

