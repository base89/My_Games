package TicTacToe;

public class TicTacToe {

    private static char[][] board = new char[3][3];

public static void main(String[] args) {
    TicTacToe ttt = new TicTacToe();
    ttt.printBoard();
    ttt.markX("11");
    ttt.printBoard();
    ttt.markO("21");
    ttt.printBoard();
    
}

public void printBoard() {
    String underRowOfBoard = "\n     [0] [1] [2]\n";
    String firstRowOfBoard = "\n[0]  | " + board[0][0] + " | "  + board[0][1] + " | " + board[0][2] + " |\n";
    String secondRowOfBoard = "[1]  | " + board[1][0] + " | "  + board[1][1] + " | " + board[1][2] + " |\n";
    String thirdRowOfBoard = "[2]  | " + board[2][0] + " | "  + board[2][1] + " | " + board[2][2] + " |\n";
    String strBoard = underRowOfBoard + firstRowOfBoard + secondRowOfBoard + thirdRowOfBoard;             
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

}