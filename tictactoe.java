package TicTacToe;

import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int row = 0; row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                board[row][col]=' ';
            }
        }
        Scanner obj = new Scanner(System.in);
        char player='X';
        boolean gameOver=false;
        while (!gameOver) {
            print(board);
            System.out.print("Player "+player+" Enter :");
            int row = obj.nextInt();
            int col = obj.nextInt();
            if(board[row][col]==' '){
                board[row][col]=player;
                gameOver = haveWon(board, player);
                if(gameOver){
                    System.out.println("Player "+player+"Won");
                }else{
                    player=(player=='X')?'O':'X';
                }
            }else{
                System.out.println("Invalid move try again.");
            }
        }
        print(board);
    }
    public static void print(char[][] board){
        for(int row = 0; row<board.length;row++){
            for(int col=0;col<board[row].length;col++){
                System.out.print(board[row][col]+" |");
            }
            System.out.println();
        }
    }
    public static boolean haveWon(char[][] board, char player){
        // rows
        for(int row =0;row<board.length;row++){
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player){
                return true;
            }
        }
        //cols
        for(int col =0;col<board[0].length;col++){
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player){
                return true;
            }
        }
        // diagonals
            if(board[0][0]==player && board[1][1]==player && board[2][2]==player){
                return true;
            }
       
            if(board[0][2]==player && board[1][1]==player && board[2][0]==player){
                return true;
            }
        
        return false;
    }
}