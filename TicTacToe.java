public class TicTacToe {


    public static void main(String[] args) {
        Board board = new Board();
        Player player1 = new Player("Player 1", 'X');
        Player player2 = new Player("Player 2", 'O');

        Game game = new Game(board, player1, player2);
        game.start();
    }


}

