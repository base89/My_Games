package TicTacToe;

import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class TicTacToe {

    private static Scanner input = new Scanner(System.in);
    private static char[][] board = new char[3][3];
    private static int[] lastMark = new int[2];

    public TicTacToe() {
    }

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void setBoard(char[][] board) {
        TicTacToe.board = board;
    }

    public static void setLastMark(int[] lastMark) {
        TicTacToe.lastMark = lastMark;
    }


    private static void fillArray() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        String underRowOfBoard = "\n      [0] [1] [2]\n";
        String firstRowOfBoard = "\n[0]  | " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + " |\n";
        String betweenRowOfBoard = "     ----+---+----\n";
        String secondRowOfBoard = "[1]  | " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + " |\n";
        String thirdRowOfBoard = "[2]  | " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " |\n";
        String strBoard = underRowOfBoard + firstRowOfBoard + betweenRowOfBoard + secondRowOfBoard + betweenRowOfBoard
                + thirdRowOfBoard;
        System.out.println("    KÓŁKO I KRZYŻYK    ");
        System.out.println("-----------------------");
        System.out.println(strBoard);
    }

    public void markX(String marks) {
        int[] field = convertStrToField(marks);
        board[field[0]][field[1]] = 'X';
        lastMark[0] = field[0];
        lastMark[1] = field[1];
    }

    public void markO(String marks) {
        int[] field = convertStrToField(marks);
        board[field[0]][field[1]] = 'O';
        lastMark[0] = field[0];
        lastMark[1] = field[1];
    }

    public static int[] convertStrToField(String mark) {
        final int CHAR_ZERO_VALUE = 48;
        int x = mark.charAt(0) - CHAR_ZERO_VALUE;
        int y = mark.charAt(1) - CHAR_ZERO_VALUE;
        return new int[] { x, y };
    }

    public void enterFieldName(int noPlayer) {
        System.out.print("Podaj pole, które chcesz zaznaczyć (np. [0][0] wpisz 00): ");
        String userMark = input.next();
        if (noPlayer == 0)
            markX(userMark);
        else
            markO(userMark);
    }

    public void switchPlayer(int noPlayer) {
        switch (noPlayer) {
            case 0:
                System.out.println("Gracz 1 -> zaznacz 'X'");
                enterFieldName(0);
                printBoard();
                if(isWin(noPlayer)) {
                    System.out.println("Gracz 1 WYGRYWA!\n");
                    System.exit(0);
                }
                break;

            case 1:
                System.out.println("Gracz 2 -> zaznacz 'O'");
                enterFieldName(1);
                printBoard();
                if(isWin(noPlayer)) {
                    System.out.println("Gracz 2 WYGRYWA!\n");
                    System.exit(0);
                }
                break;
        }
    }

    public void executeGame() {
        int noPlayer = 0;
        final int MAX_MOVES = 9;
        int moves = 0;
        while (moves < MAX_MOVES) {
            switchPlayer(noPlayer);
            noPlayer = ++noPlayer % 2;
            moves++;
        }
    }

    public boolean isWin(int noPlayer) {
        boolean winFlag = false;
        char playerMark;

        if(noPlayer == 0)
            playerMark = 'X';
        else
            playerMark = 'O';

        if (board[lastMark[0]][0] == playerMark & board[lastMark[0]][1] == playerMark & board[lastMark[0]][2] == playerMark) {
            winFlag = true;
        } else if (board[0][lastMark[1]] == playerMark & board[1][lastMark[1]] == playerMark & board[2][lastMark[1]] == playerMark) {
            winFlag = true;
        } else if (board[0][0] == playerMark & board[1][1] == playerMark & board[2][2] == playerMark) {
            winFlag = true;
        } else if (board[0][2] == playerMark & board[1][1] == playerMark & board[2][0] == playerMark) {
            winFlag = true;
        }
        return winFlag;
    }

    public static void startGame(){
        TicTacToe ttt = new TicTacToe();
        fillArray();
        ttt.printBoard();
        ttt.executeGame();
    }

    public static void displayMainMenu(){
        int menuOption;

        while (true)
        {
            clearConsole();
            System.out.println("    KÓŁKO I KRZYŻYK    ");
            System.out.println("-----------------------");
            System.out.println("1. Nowa Gra");
            System.out.println("9. Wyjdź");
            System.out.print("\nPodaj opcję: ");
            menuOption =  input.nextInt();
    
            if (menuOption == 1) {
                clearConsole();
                startGame();
            } else if (menuOption == 9) {
                System.exit(0);
            } else {
                System.out.println("Nieprawidłowe polecenie. Wybierz jeszcze raz.");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Błąd wstrzymania programu");
                } 
            }
        }
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}