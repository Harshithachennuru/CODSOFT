import java.util.*;

public class TicTacToe {
    static char[] board = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

    // Print Board
    static void printBoard() {
        System.out.println();
        for (int i = 0; i < 9; i += 3) {
            System.out.println(board[i] + " | " + board[i+1] + " | " + board[i+2]);
        }
        System.out.println();
    }

    // Check Winner
    static boolean checkWinner(char player) {
        int[][] winConditions = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
        };

        for (int[] condition : winConditions) {
            if (board[condition[0]] == player &&
                board[condition[1]] == player &&
                board[condition[2]] == player) {
                return true;
            }
        }
        return false;
    }

    // Check Draw
    static boolean isDraw() {
        for (char c : board) {
            if (c == ' ') return false;
        }
        return true;
    }

    // Minimax Algorithm
    static int minimax(boolean isMaximizing) {
        if (checkWinner('O')) return 1;
        if (checkWinner('X')) return -1;
        if (isDraw()) return 0;

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i] == ' ') {
                    board[i] = 'O';
                    int score = minimax(false);
                    board[i] = ' ';
                    bestScore = Math.max(score, bestScore);
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 9; i++) {
                if (board[i] == ' ') {
                    board[i] = 'X';
                    int score = minimax(true);
                    board[i] = ' ';
                    bestScore = Math.min(score, bestScore);
                }
            }
            return bestScore;
        }
    }

    // AI Move
    static void aiMove() {
        int bestScore = Integer.MIN_VALUE;
        int move = -1;

        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') {
                board[i] = 'O';
                int score = minimax(false);
                board[i] = ' ';
                if (score > bestScore) {
                    bestScore = score;
                    move = i;
                }
            }
        }

        board[move] = 'O';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Tic-Tac-Toe AI (You = X, AI = O)");

        while (true) {
            printBoard();

            // Human move
            System.out.print("Enter position (1-9): ");
            int pos = sc.nextInt() - 1;

            if (pos < 0 || pos > 8 || board[pos] != ' ') {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            board[pos] = 'X';

            if (checkWinner('X')) {
                printBoard();
                System.out.println("You win!");
                break;
            }

            if (isDraw()) {
                printBoard();
                System.out.println("Draw!");
                break;
            }

            // AI move
            aiMove();

            if (checkWinner('O')) {
                printBoard();
                System.out.println("AI wins!");
                break;
            }

            if (isDraw()) {
                printBoard();
                System.out.println("Draw!");
                break;
            }
        }

        sc.close();
    }
}
