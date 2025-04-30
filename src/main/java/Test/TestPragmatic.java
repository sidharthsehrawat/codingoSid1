package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestPragmatic {

    public static void main(String[] args) {
        int size = 3;
        String[][] board = new String[size][size];
        Scanner sc = new Scanner(System.in);
        String symbol = sc.nextLine();
        int i = sc.nextInt();
        int j = sc.nextInt();
        board[i][j] = symbol;

        getGameResult(board, i , j, symbol);

    }


    private static String getGameResult(String[][] board, int r , int c, String symbol) {
        // ver
        int verCount=0;
        for(int row = r , col=c; row< board.length; row++){
              if(board[row][col].equals(symbol)){
                  verCount++;
              }
        }

        if(verCount == board.length-1){
            System.out.println("Winner Found symbol" + symbol);
        }

        int horCount=0;
        for(int col = c, row = r ; col< board.length; col++){
            if(board[row][col].equals( symbol)){
                horCount++;
            }
        }

        if(horCount == board.length-1){
            System.out.println("Winner Found symbol" + symbol);
        }

   // diagnal count left dignal
        int diaCount=0;
        int row = 0;
        int col = 0;
        while(r<board.length){
            if(board[row][col].equals(symbol)){
                diaCount++;row++; col++;
            }
        }

        if(diaCount == board.length-1){
            System.out.println("Winner Found symbol" + symbol);
        }


        // diagnal count left dignal
        int diaCount1= 0;
        int row1 = 0;
        int col1 = 0;
        while(r<board.length){
            if(board[row1][col1].equals(symbol)){
                diaCount++;row1++; col1++;
            }
        }

        if(diaCount == board.length-1){
            System.out.println("Winner Found symbol" + symbol);
        }

        return "";
    }
}
