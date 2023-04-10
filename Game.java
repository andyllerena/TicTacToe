import java.util.Scanner;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Board board, Player player1, Player player2){
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void start() {
        boolean gameFinished = false;

        while (!gameFinished) {
            Board.displayBoard(board.getBoard());
            int[] move = takeTurn();
            board.getBoard()[move[0]][move[1]] = currentPlayer.getMarker();

            if (checkWin()) {
                System.out.println(currentPlayer.getName() + " wins!");
                gameFinished = true;
            } else if (checkTie()) {
                System.out.println("Tie game!");
                gameFinished = true;
            } else {
                switchPlayers();
            }
        }
    }

        private int[] takeTurn() {
            Scanner scanner = new Scanner(System.in);
            int row = -1;
            int col = -1;

            while (row < 0 || row > 2 || col < 0 || col > 2 || board.getBoard()[row][col] != ' ') {
                System.out.print(currentPlayer.getName() + ", enter a row (0-2) and column (0-2) to place your marker: ");
                row = scanner.nextInt();
                col = scanner.nextInt();
            }

            return new int[]{row, col};
        }

        private boolean checkWin() {
            char[][] gameBoard = board.getBoard();
            char marker = currentPlayer.getMarker();

            // check horizontal win conditions
            for (int row = 0; row < 3; row++) {
                if (gameBoard[row][0] == marker && gameBoard[row][1] == marker && gameBoard[row][2] == marker) {
                    return true;
                }
            }

            // check vertical win conditions
            for (int col = 0; col < 3; col++) {
                if (gameBoard[0][col] == marker && gameBoard[1][col] == marker && gameBoard[2][col] == marker) {
                    return true;
                }
            }

            // check diagonal win conditions
            if (gameBoard[0][0] == marker && gameBoard[1][1] == marker && gameBoard[2][2] == marker) {
                return true;
            }

            if (gameBoard[0][2] == marker && gameBoard[1][1] == marker && gameBoard[2][0] == marker) {
                return true;
            }

            return false;
        }

        private boolean checkTie() {
            char[][] gameBoard = board.getBoard();

            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (gameBoard[row][col] == ' ') {
                        return false;
                    }
                }
            }

            return true;
        }

        private void switchPlayers() {
            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
    }

