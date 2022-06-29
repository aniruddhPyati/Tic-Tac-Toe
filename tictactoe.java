

import java.util.Scanner;

public class tictactoe {
    static Scanner sc;

    public tictactoe() {
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the game");
        char[][] board = new char[][]{{'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'}};
        printBoard(board);

        for(int i = 0; i < 9; ++i) {
            int[] spot;
            if (i % 2 == 0) {
                System.out.println("X turn ");
                spot = askuser(board);
                board[spot[0]][spot[1]] = 'X';
            } else {
                System.out.println("O turn");
                spot = askuser(board);
                board[spot[0]][spot[1]] = 'O';
            }

            printBoard(board);
            int counter = checkwin(board);
            if (counter == 3) {
                System.out.println("X wins");
                break;
            }

            if (counter == -3) {
                System.out.println("O wins");
                break;
            }
        }

    }

    static void printBoard(char[][] board) {
        System.out.print("\n");

        for(int i = 0; i < board.length; ++i) {
            System.out.print(" ");

            for(int j = 0; j < board[i].length; ++j) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
            System.out.println();
        }

    }

    static int[] askuser(char[][] board) {
        System.out.print("Pick a row and column , remember the numbering starts from 0");
        int row = sc.nextInt();

        int column;
        for(column = sc.nextInt(); board[row][column] != '_'; column = sc.nextInt()) {
            System.out.println("This spot was already taken , try again");
            row = sc.nextInt();
        }

        return new int[]{row, column};
    }

    static int checkwin(char[][] board) {
        int counter = 0;

        int i;
        int j;
        for(i = 0; i < board.length; ++i) {
            for(j = 0; j < board[i].length; ++j) {
                if (board[i][j] == 'X') {
                    ++counter;
                } else if (board[i][j] == 'O') {
                    --counter;
                }
            }

            if (counter == 3 || counter == -3) {
                return counter;
            }

            counter = 0;
        }

        for(i = 0; i < 3; ++i) {
            for(j = 0; j < board.length; ++j) {
                if (board[j][i] == 'X') {
                    ++counter;
                } else if (board[j][i] == 'O') {
                    --counter;
                }
            }

            if (counter == 3 || counter == -3) {
                return counter;
            }

            counter = 0;
        }

        for(i = 0; i < 3; ++i) {
            if (board[i][i] == 'X') {
                ++counter;
            } else if (board[i][i] == 'O') {
                --counter;
            }
        }

        if (counter != 3 && counter != -3) {
            counter = 0;

            for(i = 0; i < 3; ++i) {
                if (board[i][2 - i] == 'X') {
                    ++counter;
                } else if (board[i][2 - i] == 'O') {
                    --counter;
                }
            }

            if (counter != 3 && counter != -3) {
                int counter = 0;
                return counter;
            } else {
                return counter;
            }
        } else {
            return counter;
        }
    }

    static {
        sc = new Scanner(System.in);
    }
}
