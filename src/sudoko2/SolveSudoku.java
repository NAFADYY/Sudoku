package sudoko2;

import javax.xml.validation.Validator;

public class SolveSudoku extends validator implements Runnable{

    private final int  SIZE=9;
    //private int[][] soluteSudoku;
    private int[][] mainSudoku;


    public SolveSudoku(int[][] sudoku) {
        super(sudoku);
    }

    public SolveSudoku(int[][] sudoku, int[][] mainSudoku) {
        super(sudoku);
        this.mainSudoku = mainSudoku;
    }



    public void printSolution(int[][] solution,int[][] mainSudoku) throws InterruptedException {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                if (solution[i][j] != mainSudoku[i][j] ){
                    solution[i][j] = mainSudoku[i][j];
                }
                System.out.print(solution[i][j]+"\t");
            }
            System.out.println();
        }


    }

    public boolean SoluteSudoku(int[][] soluteSudoku, int[][] mainSudoku) throws InterruptedException{
        soluteSudoku=sudoku;
        mainSudoku=this.mainSudoku;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (soluteSudoku[i][j]!=mainSudoku[i][j]){

                    return true;

                }

            }

        }
        return false;
    }

    @Override
    public void run() {

        try {
            if (SoluteSudoku(sudoku,mainSudoku)){
                System.out.println("Invalid");

                System.out.println("******************New array******************");
//                printSolution(sudoku,mainSudoku);

            }
            else {
                System.out.print("Validh");

            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
