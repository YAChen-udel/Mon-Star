package cisc181.lab_6;

public class TicTacToeTypeGame extends Game {
    /*
    static method to initial the board
     */
    public static GamePiece[][] setUpEmptyArray(int numRows,int numCols){
        GamePiece[][] result=new GamePiece[numRows][numCols];
        for(int i=0;i<numRows;i++){
            for(int j=0;j<numCols;j++){
                result[i][j]=new GamePiece(GamePiece.EMPTY);
            }
        }
        return result;
    }
    private GameBoard board;
    private char turnSymbol;
    private char notTurnSymbol;
    private int numRows;
    private int numCols;
    private int numConsecToWin;
    /*
    constructor that accepts turnSymbol, notTurnSymbol, numRows, numCols, numConsecToWin and sets
    these properties.The constructor also sets up the GameBoard property to hold all EMPTY GamePieces.
     */
    public TicTacToeTypeGame(char turnSymbol,char notTurnSymbol,int numRows, int numCols, int numConsecToWin){
        this.turnSymbol=turnSymbol;
        this.notTurnSymbol=notTurnSymbol;
        this.numRows=numRows;
        this.numCols=numCols;
        this.numConsecToWin=numConsecToWin;
        board=new GameBoard(setUpEmptyArray(numRows,numCols));
    }
    /*
    getter for gameboard
     */
    public GameBoard getGameBoard() {
        return board;
    }
    /*
    getter for turnsymbol
     */
    public char getTurnSymbol() {
        return turnSymbol;
    }
    /*
    getter for notturnsymbol
     */
    public char getNotTurnSymbol() {
        return notTurnSymbol;
    }
    /*
    swap the turnsymbol and notturnsymbol
     */
    public void changeTurn(){
        char tmp=turnSymbol;
        turnSymbol=notTurnSymbol;
        notTurnSymbol=tmp;
    }
    /*
    setter accept symbol, col,a and row to set the piece on the board
     */
    public void setPieceOnBoard(int row, int col, GamePiece piece){
        board.setPiece(row,col,piece);
    }
    /*
    return the score of the given symbol
     */
    public int getScore(char symbol){
        return board.getMaxConsec(symbol);
    }
    /*
    return true if the score of that symbol is equal to numconsectowin
     */
    public boolean isWinner(char symbol){
        return getScore(symbol)==numConsecToWin;
    }
    /*
    return true if there is no empty space or there is a winner
     */
    public boolean isEnd(){
        return (!board.hasEmptySpace())||isWinner(turnSymbol)||isWinner(notTurnSymbol);
    }
    /*
    get the status of the game
     */
    public String getStatus(){
        if(!(isWinner(turnSymbol)||isWinner(notTurnSymbol))){
            return "Player "+Character.toString(turnSymbol)+"'s turn";
        }
        else if(isWinner(turnSymbol)){
            return "Player "+Character.toString(turnSymbol)+" wins!";
        }
        else if(isWinner(notTurnSymbol)){
            return "Player "+Character.toString(notTurnSymbol)+" wins!";
        }
        else{
            return "It is a draw";
        }
    }
    /*

     */

    @Override
    public String toString() {
        return board.toString()+getStatus();
    }
}
