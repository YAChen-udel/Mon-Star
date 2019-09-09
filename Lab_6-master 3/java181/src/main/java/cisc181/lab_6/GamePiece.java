package cisc181.lab_6;

public class GamePiece {
    static final char EMPTY = 'E';
    private char symbol;
    public GamePiece(char symbol){
        this.symbol=symbol;
    }
    /*
    return the symbol
     */
    public char getSymbol() {
        return symbol;
    }
    /*
    return weather the spot is empty
     */
    public boolean isEmpty(){
        return symbol==EMPTY;
    }
    /*
    override tostring to return the symbol
     */
    @Override
    public String toString() {
        return Character.toString(symbol);
    }
    /*
    return the game piece is equal or not base on the symbol
     */
    public boolean equals(GamePiece o) {
        return o.symbol==this.symbol;
    }

}
