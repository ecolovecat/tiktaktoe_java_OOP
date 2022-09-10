enum CellStatus {
    X("X"),
    O("O"),
    EMPTY("-");

    private String value;

    private CellStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}