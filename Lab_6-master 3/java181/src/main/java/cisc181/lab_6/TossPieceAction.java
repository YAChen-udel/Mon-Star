package cisc181.lab_6;

public class TossPieceAction implements Action<TicTacToeTypeGame> {
    int row;
    int col;
    char player;
    public TossPieceAction(char player,int row, int col){
        this.player=player;
        this.row=row;
        this.col=col;
    }

    public char getPlayer() {
        return player;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isValid(TicTacToeTypeGame game){
        return game.getTurnSymbol()==player&&game.getGameBoard().isInBounds(row,col);
    }
    public void update(TicTacToeTypeGame game){
        game.setPieceOnBoard(row,col,new GamePiece(player));
        game.changeTurn();
    }

    @Override
    public String toString() {
        return "Tossing "+Character.toString(player)+" on row "+row+", col "+col+".";
    }
}
