public class Board {
    Cell[][] cells;

        public void initGame() {
            cells = new Cell[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cells[i][j] = new Cell(i,j);
                    cells[i][j].status = CellStatus.EMPTY;
                }
            }
        }

    public void paint() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(" ");
//                System.out.print("X");
                cells[row][col].renderCell();
                System.out.print(" ");
                if (col < 3 - 1) System.out.print("|");  // column separator
            }
            System.out.println();
            if (row < 3 - 1) {
                System.out.println("-----------");  // row separator
            }
        }


    }

    // 1: X
    // 2: O
    // 3: draw
    // 4: still playing
    public int checkWin(CellStatus currentPlayer, int selectedRow, int selectedCol) {
        if (cells[selectedRow][0].status == currentPlayer
                && cells[selectedRow][1].status == currentPlayer
                && cells[selectedRow][2].status == currentPlayer
                || cells[0][selectedCol].status == currentPlayer
                && cells[1][selectedCol].status == currentPlayer
                && cells[2][selectedCol].status == currentPlayer
                || selectedRow == selectedCol
                && cells[0][0].status == currentPlayer
                && cells[1][1].status == currentPlayer
                && cells[2][2].status == currentPlayer
                || selectedRow + selectedCol == 2
                && cells[0][2].status == currentPlayer
                && cells[1][1].status == currentPlayer
                && cells[2][0].status == currentPlayer) {
            return (currentPlayer == CellStatus.X) ? 1 : 2;
        } else {
            // check draw
            for (int row = 0; row < 3; ++row) {
                for (int col = 0; col < 3; ++col) {
                    if (cells[row][col].status == CellStatus.EMPTY) {
                        return 4; // playing
                    }
                }
            }
            return 3; // draw
        }
    }
}