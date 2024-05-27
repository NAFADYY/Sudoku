package sudoko2;

public class sudokuObject {

  static int SIZE = 9;
    int[][] sudoku ;
    int row;
    int column;
    int value;
    sudokuObject(int row, int column ,int value,int [][]sudoku ) {
        this.row = row;
        this.column = column;
        this.value = value;
        this.sudoku = sudoku;
    }
}
