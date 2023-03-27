package TicTacToe;

public class TicTacToe {

    private static char[][] board = new char[3][3];

public static void main(String[] args) {
    TicTacToe ttt = new TicTacToe();
    ttt.printBoard();
    
}

public void printBoard() {
    String firstRowOfBoard = "\n| " + board[0][0] + " | "  + board[0][1] + " | " + board[0][2] + " |\n";
    String secondRowOfBoard = "| " + board[1][0] + " | "  + board[1][1] + " | " + board[1][2] + " |\n";
    String thirdRowOfBoard = "| " + board[2][0] + " | "  + board[2][1] + " | " + board[2][2] + " |\n";
    String strBoard = firstRowOfBoard + secondRowOfBoard + thirdRowOfBoard;             
    System.out.println(strBoard);
}

}