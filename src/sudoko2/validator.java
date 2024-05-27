package sudoko2;



public class validator implements Runnable{

    private static final int SIZE = 9;
    public int sudoku[][];



    public validator(int [][]sudoku) {
        this.sudoku= sudoku;

    }


    public void SudokuValidtion() throws InterruptedException {
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                if (sudoku[row][column] > 0 && sudoku[row][column] < 10) {
                    Row R = new Row(row, column, sudoku[row][column], sudoku);
                    column c = new column(row, column, sudoku[row][column], sudoku);
                    Valid3 B = new Valid3(row, column, sudoku[row][column], sudoku);
                    Thread t1 = new Thread(R);
                    Thread t2 = new Thread(c);
                    Thread t3 = new Thread(B);
                    t1.start();
                    t2.start();
                    t3.start();
                    t1.join();
                    t2.join();
                    t3.join();
                }
            }
        }
    }

    @Override
    public void run() {
        try {

            SudokuValidtion();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

//https://github.com/sarmadhashmi/multithreaded-sudoku-validator/blob/master/JavaSudokuValidator.java