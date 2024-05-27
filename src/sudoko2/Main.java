/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoko2;

/**
 *
 * @author moham
 */
import sudoko2.SudokuSolver;
import java.util.Scanner;
import sudoko2.validator;

public class Main {
    public static int [][][]valid=new int[9][9][3];

    //Answer board
    public static  int[][] sudoku = {
            {6, 2, 4, 5, 3, 9, 1, 8, 7},
            {0, 1, 9, 7, 2, 8, 6, 3, 4},
            {8, 3, 7, 6, 1, 4, 2, 9, 5},
            {0, 4, 3, 8, 6, 5, 7, 2, 9},
            {9, 5, 8, 2, 4, 7, 3, 6, 1},
            {7, 6, 2, 3, 9, 1, 4, 5, 8},
            {3, 7, 1, 9, 5, 6, 8, 4, 2},
            {4, 9, 6, 1, 8, 2, 5, 7, 3},
            {2, 8, 5, 4, 7, 3, 9, 1, 6}
//            {3 ,1 ,6 ,5 ,7 ,8 ,4 ,9 ,2},
//            {5 ,2 ,9 ,1 ,3 ,4 ,7 ,6 ,8},
//            {4 ,8 ,7 ,6 ,2 ,9 ,5 ,3 ,1},
//            {2 ,6 ,3 ,4 ,1 ,5 ,9 ,8 ,7},
//            {9 ,7 ,4 ,8 ,6 ,3 ,1 ,2 ,5},
//            {8 ,5 ,1 ,7 ,9 ,2 ,6 ,4 ,3},
//            {1 ,3 ,8 ,9 ,4 ,7 ,2 ,5 ,6},
//            {6 ,9 ,2 ,3 ,5 ,1 ,8 ,7 ,4},
//            {7 ,4 ,5 ,2 ,8 ,6 ,3 ,1 ,9}
    };

    // value 0 represents an empty value and user should fill it
   public static  int[][] SoluteSudoku=new int[][]{
            {6, 2, 4, 5, 3, 9, 1, 8, 7},
            {0, 1, 9, 7, 2, 8, 6, 3, 4},
            {8, 3, 7, 6, 1, 4, 2, 9, 5},
            {0, 4, 3, 8, 6, 5, 7, 2, 9},
            {9, 5, 8, 2, 4, 7, 3, 6, 1},
            {7, 6, 2, 3, 9, 1, 4, 5, 8},
            {3, 7, 1, 9, 5, 6, 8, 4, 2},
            {4, 9, 6, 1, 8, 2, 5, 7, 3},
            {2, 8, 5, 4, 7, 3, 9, 1, 6}

//            { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
//            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
//            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
//            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
//            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
//            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
//            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
//            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
//            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
    };
//            2
//            9
//            1
//            5
//            9
//            2
//            8
//            3
//            7
//            9
//            5
//            1
//            9
//            8

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner=new Scanner(System.in);
        new Gui();

        //copy SoluteSudoku array to sudoku array
        // and sudoku array should display to user to fill it
//        for (int i = 0; i < SoluteSudoku.length; i++) {
//            for (int j = 0; j < SoluteSudoku.length; j++) {
//                sudoku[i][j] = SoluteSudoku[i][j];
//            }
//        }
//
//        //user can enter an answer instead 0 value
//        for (int i = 0; i < sudoku.length; i++) {
//            for (int j = 0; j < sudoku.length; j++) {
//                if (sudoku[i][j]==0){
//                    System.out.print("Arr["+i+"]["+j+"]: ");
//                    sudoku[i][j]=scanner.nextInt();
//                }
//            }
//        }
        
//        System.out.println("******************Your Solution******************");
//
//        for (int i = 0; i < Main.sudoku.length; i++) {
//            for (int j = 0; j < Main.sudoku.length; j++) {
//                System.out.print(Main.sudoku[i][j]+"\t");
//            }
//            System.out.println();
//        }

//        validator v=new validator(Main.sudoku);
//
//        Thread T1=new Thread(v);
//
//        T1.start();
//        T1.join();


//       for (int i =0;i<9;i++){
//           for (int j=0; j<9; j++){
//               System.out.print(" ");
//               for (int k=0; k<3; k++){
//                   System.out.print(valid[i][j][k]);
//               }
//           }
//           System.out.print("\n");
//           }

          //check if sudoku array is correct
//           for (int i =0;i<9;i++){
//               for (int j=0; j<9; j++){
//                   for (int k=0; k<3; k++){
//                       if(valid[i][j][k]==0){
//                       System.out.println("Incorrect solution");
//                       System.out.println("******************Solute array******************");
//                       SudokuSolver solver=new SudokuSolver(SoluteSudoku);
//                       //this thread print the solution
//                       Thread T2=new Thread(solver);
//                       T2.start();
//                       T2.join();
//
//                       return;
//                       }
//                    }
//
//               }
//           }
           
//           System.out.print("valid");




    }
}