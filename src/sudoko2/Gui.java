/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoko2;

import sudoko2.Main;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import static sudoko2.Main.SoluteSudoku;
import sudoko2.SolveSudoku;

/**
 *
 * @author NAFADY
 */
public class Gui extends JFrame implements ActionListener, MouseListener, KeyListener {
    
    public static int[][][] valid = new int[9][9][3];
    public int col;
    public int row;
    public int[][] solArr = Main.SoluteSudoku;
    public int[][]tmpArr = Main.sudoku;
    public JLabel msg = new JLabel();
    JButton submit = new JButton("submit");
    JTextField value = new JTextField();
    JButton play = new JButton("Play");
    JButton myAns = new JButton("My Answer");
 
    JButton show = new JButton("Show Me");
    JButton reset = new JButton("Reset");
    private JPanel grid, control;
    private Color c1 = new Color(255, 128, 64), c2 = new Color(255, 164, 119);
    
    private JLabel[][] board = new JLabel[9][9];
    private int[][] intBoard = new int[9][9];
    
    public Gui() {
//        this.jTextField1KeyPressed();
        this.setTitle("N Queen With MultiThreads Mooo_NAsr");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1010, 560);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        this.creatGrid();
        this.createControlPanel();
        this.addKeyListener(this);
        this.add(grid);
        this.add(control);
//        this.value.requestFocus();
        this.value.requestFocus();
        
        
        this.repaint();
        this.setVisible(true);
    }
    
    private void creatGrid() {
        grid = new JPanel();
        
        grid.setLayout(new GridLayout(9, 9));
        grid.setSize(660, 520);
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                
                board[i][j] = new JLabel();
                board[i][j].addMouseListener(this);
                board[i][j].addKeyListener(this);
                board[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));                
                board[i][j].setSize(640 / (9 * 9), 520 / (9 * 9));
                board[i][j].setOpaque(true);
                
                if ((i + j) % 2 == 0) {
                    board[i][j].setBackground(Color.black);
                } else {
                    board[i][j].setBackground(c1);
                }
                
                grid.add(board[i][j]);
            }
        }
        
    }
    
    private void createControlPanel() {
        control = new JPanel();
        control.setLayout(null);
        control.setOpaque(true);
        control.setBackground(c1);
        control.add(this.msg);
        msg.setBounds(680, 250, 300, 40);
        
        control.add(this.value);
        control.add(submit);
        
        value.setBounds(750, 140, 110, 30);
        
        value.addKeyListener(this);
//        control.setSize(200,120);

        submit.setBounds(750, 100, 110, 30);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        
        myAns.setBounds(750, 100, 110, 30);
        myAns.setBackground(Color.black);
        myAns.setForeground(Color.white);
        
        
        play.setBounds(750, 20, 110, 30);
        play.setBackground(Color.black);
        play.setForeground(Color.white);
        show.setBounds(750, 60, 110, 30);
        show.setBackground(Color.black);
        show.setForeground(Color.white);
        reset.setBounds(750, 470, 110, 30);
        reset.setBackground(Color.black);
        reset.setForeground(Color.white);
        
        show.addActionListener(this);
        submit.addActionListener(this);
        reset.addActionListener(this);
        play.addActionListener(this);
        
        control.add(this.play);
//        control.add(myAns);
        control.add(show);
        control.add(reset);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == submit) {
            boolean flag = true;
//            System.out.println("aaaaaaaaa");
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
//                    System.out.println(board[i][j].getText());
                    if (Integer.parseInt(board[i][j].getText()) == 0) {
//                    System.out.println("aaaaaaaaaaaaaaaaaaaaa");
                        board[i][j].setOpaque(true);
                        board[i][j].setBackground(Color.red);
                        flag = false;
                    }
                    intBoard[i][j] = Integer.parseInt(board[i][j].getText());
                }
            }
            if (flag) {
                System.out.println("my board");
                this.printArray(intBoard);
                try {
                    validator v = new validator(intBoard);
                    
                    Thread T1 = new Thread(v);
                    
                    T1.start();
                    T1.join();
                    
                    for (int i = 0; i < 9; i++) {
                        for (int j = 0; j < 9; j++) {
                            for (int k = 0; k < 3; k++) {
                                if (valid[i][j][k] == 0) {
//                                    System.out.println("Incorrect solution");
//                                    System.out.println("******************Solute array******************");
                                    SudokuSolver solver = new SudokuSolver(SoluteSudoku);
                                    //this thread print the solution
                                    Thread T2 = new Thread(solver);
                                    T2.start();
                                    T2.join();
                                    break;
                                    
                                }
                            }
                        }
                    }
                    System.out.println("");
                    if (Arrays.deepEquals(SoluteSudoku, intBoard)) {
                        this.msg.setText("Your Answer is Valid ");
                        System.out.println("validd");
                    } else {
                        this.msg.setText("Your Answer is Wrong click Show, check Red Box");
                        System.out.println("noo");
                        System.out.println("solution is");
                        this.printArray(SoluteSudoku);
                    }
                } catch (InterruptedException ex) {
//                    Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
        
        if (e.getSource() == play) {
            this.resetGrid();
            this.randomZeros(7);
//            this.printArray(solArr);
            System.out.println("");
//            this.printArray(SoluteSudoku);
            System.out.println("");
//            this.printArray(tmpArr);
            System.out.println("");
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if(Main.sudoku[i][j] == 0){
                        board[i][j].setBackground(Color.red);
                        
                    }
                    this.board[i][j].setOpaque(true);
                    this.board[i][j].setForeground(Color.white);
                    this.board[i][j].setText("" + Main.sudoku[i][j]);
//                        this.board[i][j].setIcon(img);
                    this.board[i][j].setHorizontalAlignment(JLabel.CENTER);
                    this.repaint();
                }
                
            }

//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        if (e.getSource() == show) {
            for (int i = 0; i < intBoard.length; i++) {
                for (int j = 0; j < intBoard.length; j++) {
                    if (intBoard[i][j] != SoluteSudoku[i][j]) {
                        this.board[i][j].setBackground(Color.RED);
                    }
                    this.board[i][j].setText("" + intBoard[i][j]);
                }
            }
            
        }
        if (e.getSource() == reset) {
            this.resetGrid();
            this.resetControl();
            
        }
    }
    
    private void resetControl() {
        this.msg.setText("");
        
    }
    
    private void resetGrid() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((i + j) % 2 == 0) {
                    board[i][j].setBackground(Color.black);
                } else {
                    board[i][j].setBackground(c1);
                }
                board[i][j].setText("");
            }
        }
//        SoluteSudoku = Main.sudoku; 
//        solArr = tmpArr.clone();
        this.repaint();

        
    }

    
    @Override
    public void mouseClicked(MouseEvent e) {
        this.col = (e.getXOnScreen() - 185) / 73;
        this.row = (e.getYOnScreen() - 115) / 60;
        value.setText(board[row][col].getText());
        
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
//        System.out.println("adad");

//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
//        this.jTextField1KeyPressed(e);

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            // Do something
            board[row][col].setText(value.getText());
            if ((row + col) % 2 == 0) {
                board[row][col].setBackground(Color.black);
            } else {
                board[row][col].setBackground(c1);
            }

//            board[row][col].setBackground(c1);
        }

//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void printArray(int board[][]) {
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public void randomZeros(int n){
        for(int i = 0 ; i < n ; i++){
            int randRow = (int) ( (Math.random()*((8 - 0)) + 0));
            int randCol = (int) ( (Math.random()*((8 - 0)) + 0));
//            System.out.println("row: "+randRow);
//            System.out.println("row: "+randRow);
//            SoluteSudoku[randRow][randCol] = 0;

        
        }
    }
    
    
    
}
