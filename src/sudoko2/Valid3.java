package sudoko2;

public class Valid3 extends sudokuObject implements Runnable
{
    Valid3(int row, int column, int value,int sudoku[][]) {
        super(row, column, value,sudoku);
    }
    int z=0;
    @Override
    public void run(){


        int BoxR= row - row % 3;
        int BoxC = column - column % 3;
        for (int i = BoxR; i < BoxR + 3; i++) {
            for (int j = BoxC; j < BoxC + 3; j++) {
                int number =sudoku[i][j];
                if(value==number && i!=column && j!=column){
                    return;
                }
                else if( value< 1 || value > 9 ){
                    return;
                }
            }
        }

        Main.valid[row][column][2]=1;

    }
    }


