import java.util.Scanner;

public class Game {

    public static void main(String[] args) {

        Board board = new Board();
        board.initGame();
        CellStatus currentPlayer = CellStatus.X;

        Scanner sc = new Scanner(System.in);

        int flag = 4;
        // 1: X
        // 2: O
        // 3: draw
        // 4: still playing

        board.paint();
        while (flag == 4) {
            System.out.println("Current player's turn: " + currentPlayer);
            System.out.println("Enter " + currentPlayer +" coordinate");
            int point_x = sc.nextInt();
            int point_y = sc.nextInt();


            if (point_x < 4 && point_x > 0 && point_y < 4 && point_y > 0 && board.cells[point_x - 1][point_y - 1].status == CellStatus.EMPTY) {
                //update current player
//                System.out.println(board.cells[point_x - 1][point_y - 1].status == CellStatus.EMPTY ? "OK" : "NO");

                board.cells[point_x - 1][point_y - 1].status = currentPlayer;
                board.paint();

                flag = board.checkWin(currentPlayer, point_x - 1, point_y - 1);

                if (currentPlayer == CellStatus.X) {
                    currentPlayer = CellStatus.O;
                } else {
                    currentPlayer = CellStatus.X;
                }
            } else if (point_x < 4 && point_x > 0 && point_y < 4 && point_y > 0 && board.cells[point_x - 1][point_y - 1].status != CellStatus.EMPTY) {
                System.out.println("This coordinate was taken");
                board.paint();
            } else {
                System.out.println("Invalid coordinate");
                board.paint();
            }
            System.out.println(flag);

        }
        if (flag == 1) {
            System.out.println("X WON!");
        } else if (flag == 2) {
            System.out.println("Y Won");
        } else {
            System.out.println("Draw");

        }

    }
}
