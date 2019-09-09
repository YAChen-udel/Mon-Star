package cisc181.lab_6;

public class FoodFight extends Game{
    public static GamePiece[][] setUpBoard(int numRows,int numCols,Player playerA,Player playerB,int FoodScore,int Aging){
        GamePiece[][] result=new GamePiece[numRows][numCols];
        for(int i=0;i<numRows;i++){
            for(int j=0;j<numCols;j++){
                result[i][j]=new Food(Food.FOOD,FoodScore);
            }
        }
        result[0][0]=playerA;
        result[numRows-1][numCols-1]=playerB;
        int x=(int)(Math.random() * (numRows));
        int y=(int)(Math.random() * (numCols));
        while((x==0&&y==0)||(x==numRows-1&&y==numCols-1)){
            x=(int)(Math.random() * (numRows));
            y=(int)(Math.random() * (numCols));
        }
        result[x][y]=new SuperFood(SuperFood.SUPER,Aging);
        return result;
    }
    private GameBoard board;
    private Player playerA;
    private Player playerB;
    private int numRows;
    private int numCols;
    private int FoodScore;
    private int Aging;

    public FoodFight(Player playerA,Player playerB,int numRows, int numCols,int FoodScore, int Aging){
        this.playerA=playerA;
        this.playerB=playerB;
        this.numRows=numRows;
        this.numCols=numCols;
        board=new GameBoard(setUpBoard(numRows,numCols,playerA,playerB,FoodScore,Aging));
    }

    public GameBoard getBoard() {
        return board;
    }

    public Player getTurnPlayer() {
        return playerA;
    }

    public Player getNotPlayer() {
        return playerB;
    }

    public void changeTurn(){
        Player tmp=playerA;
        playerA=playerB;
        playerB=tmp;
    }

    public boolean hasFood(){
        boolean res=false;
        for(int i=0;i<numRows;i++){
            for(int j=0;j<numCols;j++){
                if(board.getPiece(i,j).getSymbol()==Food.FOOD||board.getPiece(i,j).getSymbol()==SuperFood.SUPER){
                    res=true;
                }
            }
        }
        return res;
    }
    public int[] getLoc(Player player){
        int[] res=new int[2];
        for(int i=0;i<numRows;i++){
            for(int j=0;j<numCols;j++){
                if(board.getPiece(i,j).getSymbol()==player.getSymbol()){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return res;
    }
    public void setPiece(int row, int col, GamePiece piece){
        board.setPiece(row,col,piece);
    }
    public String Winner(){
        if(isEnd()){
            if(playerA.getScore()>playerB.getScore()){
                return "Player "+Character.toString(playerA.getSymbol())+" wins with "+playerA.getScore()+" points.";
            }
            else if(playerA.getScore()<playerB.getScore()){
                return "Player "+Character.toString(playerB.getSymbol())+" wins with "+playerB.getScore()+" points.";
            }
            else{
                return "Draw";
            }
        }
        else{
            return "Game not end";
        }
    }
    @Override
    public boolean isEnd() {
        return (!hasFood());
    }

    public String toString(){
        return board.toString();
    }
}
