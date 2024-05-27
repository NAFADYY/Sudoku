package sudoko2;

import javax.xml.validation.Validator;

public class SudokuSolver implements Runnable{
    private final int SIZE=9;
    private int[][]grid;
    private int r;
    private int col;
    //meeeeeeeeeeeee
    public static int sol[][] = new int[9][9];

    public SudokuSolver(int[][] grid) {
        this.grid = grid;

    }

    boolean SolveSudoku(int[][] grid, int r, int col) throws InterruptedException{


        if (r == SIZE - 1 && col==SIZE)

            return true;

        if (col==SIZE){
            r++;
            col=0;
        }
        if (grid[r][col]!=0){
            return SolveSudoku(grid,r,col+1);
        }

        for (int num = 1; num <10 ; num++) {
            if (isSafe(grid,r,col,num)){
                grid[r][col]=num;
                if (SolveSudoku(grid,r,col+1))
                    return true;
            }
            grid[r][col]=0;

        }
        return false;
    }

    private boolean isSafe(int[][] grid, int r, int col, int num) {
        for (int i = 0; i <=8 ; i++) {
            if (grid[r][i]==num){
                return false;
            }
        }

        for (int j = 0; j <= 8 ; j++) {
            if (grid[j][col]==num){
                return false;
            }
        }

        int startRowInSubSection = r - r % 3;
        int startColumnInSubSection=col-col%3;

        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                if (grid[i+startRowInSubSection][j+startColumnInSubSection]==num){
                    return false;
                }
            }
        }
        return true;
    }

    void printSolution(int [][] grid) throws InterruptedException{
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(grid[i][j]+"\t");
            }
            System.out.println();
        }

    }


    @Override
    public void run() {

        try {
            if (SolveSudoku(grid,r,col)){
//                System.out.println("heeeer");
//                printSolution(grid);
                //meeeeeeeeeeeee
                sol = grid.clone();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
