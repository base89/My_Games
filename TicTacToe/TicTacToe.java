package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

    private static Scanner input = new Scanner(System.in);
    private static char[][] board = new char[3][3];

public static void main(String[] args) {
    TicTacToe ttt = new TicTacToe();
    fillArray();
    ttt.printBoard();
    ttt.enterFieldName(false);
    ttt.printBoard();
    ttt.enterFieldName(true);
    ttt.printBoard();
    
}

private static void fillArray() {
    for(int i = 0; i < 3; i++) {
        for(int j = 0; j < 3; j++) {
            board[i][j] = ' ';
        }
    }
}

public void printBoard() {
    String underRowOfBoard = "\n      [0] [1] [2]\n";
    String firstRowOfBoard = "\n[0]  | " + board[0][0] + " | "  + board[0][1] + " | " + board[0][2] + " |\n";
    String betweenRowOfBoard = "     ----+---+----\n";
    String secondRowOfBoard = "[1]  | " + board[1][0] + " | "  + board[1][1] + " | " + board[1][2] + " |\n";
    String thirdRowOfBoard = "[2]  | " + board[2][0] + " | "  + board[2][1] + " | " + board[2][2] + " |\n";
    String strBoard = underRowOfBoard + firstRowOfBoard + betweenRowOfBoard + secondRowOfBoard + betweenRowOfBoard + thirdRowOfBoard;             
    System.out.println(strBoard);
}

public void markX(String marks) {
    int[] field = convertStrToField(marks);
    board[field[0]][field[1]] = 'X';
}

public void markO(String marks) {
    int[] field = convertStrToField(marks);
    board[field[0]][field[1]] = 'O';
}

public static int[] convertStrToField(String mark) {
    int x = mark.charAt(0) - 48;
    int y = mark.charAt(1) - 48;
    return new int[] {x, y};
}

public void enterFieldName(boolean whichPlayer) {
    System.out.print("Podaj pole, które chcesz zaznaczyć: ");
    String userMark = input.next();
    if (whichPlayer == false) {
        markX(userMark);
    } else {
        markO(userMark);
    }
}

}