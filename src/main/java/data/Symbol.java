package data;

public enum Symbol {
    COLON(":"),
    EQUALS("="),
    COMMA(",");

    private final String symbol;
    private Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
