package cisc181.lab_6;

public class GameBoard {
    private GamePiece[][] board;
    public GameBoard(GamePiece[][] board){
        this.board=board;
    }
    /*
    return the gameboard
     */
    public GamePiece[][] getBoard() {
        return board;
    }
    /*
    return the piece at row col at the board
     */
    public GamePiece getPiece(int row,int col){
        return board[row][col];
    }
    /*
    set the piece at row,col of the board to piece
     */
    public void setPiece(int row, int col, GamePiece piece){
        board[row][col]=piece;
    }
    /*
    find if there is a empty spot on the board
     */
    public boolean hasEmptySpace(){
        boolean result=false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j].isEmpty()){
                    result=true;
                }
            }
        }
        return result;
    }
    /*
    check if the point row, col is in the board
     */
    public boolean isInBounds(int row,int col) {
        return row < board.length && col < board[0].length&&row>=0&&col>=0;
    }
    /*
    print the board
     */
    public void printBoard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    /*
    count how many symbol on the spot from startrow,startcol, and step with deltarow deltacol
     */
    public int getNumConsec(int startRow,int startCol,int deltaRow, int deltaCol,char symbol){
        int num=0;
        int max=0;
        if(isInBounds(startRow,startCol)){
            if(startCol==0&&deltaRow==0){
                for(int i=startCol;i<board[startRow].length;i+=deltaCol){
                    if(board[startRow][i].getSymbol()==symbol){
                        num+=1;
                    }
                    else {
                        num = 0;
                    }
                    max=Math.max(max,num);
                }
            }
            else if(startRow==0&&deltaCol==0){
                for(int i=startRow;i<board.length;i+=deltaRow){
                    if(board[i][startCol].getSymbol()==symbol){
                        num+=1;
                    }
                    else{
                        num=0;
                    }
                    max=Math.max(max,num);
                }
            }
            else{
                int i=startRow;
                int j=startCol;
                while(isInBounds(i,j)){
                    if(board[i][j].getSymbol()==symbol){
                        num+=1;
                    }
                    else{
                        num=0;
                    }
                    max=Math.max(max,num);
                    i+=deltaRow;
                    j+=deltaCol;
                }
            }
        }
        return max;
    }
    /*
    ccepts a symbol and returns the largest number of consecutive positions for this symbol either
    across the row, down a column or diagonal.
     */
    public int getMaxConsec(char symbol){
        int num=0;
        int max=0;
        for(int i=0;i<board.length;i++){
            max=Math.max(max,getNumConsec(i,0,0,1,symbol));
            max=Math.max(max,getNumConsec(0,i,1,0,symbol));
        }
        max=Math.max(max,getNumConsec(0,0,1,1,symbol));
        max=Math.max(max,getNumConsec(0,board.length-1,1,-1,symbol));
        return max;
    }
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                buffer.append(board[i][j] + " ");
            }
            buffer.append("\n");
        }
        return buffer.toString();
    }

}
