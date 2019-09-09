package cisc181.lab_6;

public class PlacePieceAction implements Action<TicTacToeTypeGame> {
    private int row;
    private int column;
    private char player;
    public PlacePieceAction(char player, int row, int column){
        this.player=player;
        this.row=row;
        this.column=column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getPlayer() {
        return player;
    }

    @Override
    public boolean isValid(TicTacToeTypeGame game) {
        GameBoard board=game.getGameBoard();
        return game.getTurnSymbol()==player&&board.isInBounds(row,column)&&board.getPiece(row,column).getSymbol()==GamePiece.EMPTY;
    }
    public void update(TicTacToeTypeGame game){
        game.setPieceOnBoard(row,column,new GamePiece(player));
        game.changeTurn();
    }

    @Override
    public String toString() {
        return "Place "+Character.toString(player)+" on row "+row+", col "+column+".";
    }
}
