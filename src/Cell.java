public class Cell {

    CellStatus status;
    int x,y;

    //constructor
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
        this.status = CellStatus.EMPTY;
    }

    public void renderCell() {
        String icon = this.status.getValue();
        System.out.print(icon);
    }
}
