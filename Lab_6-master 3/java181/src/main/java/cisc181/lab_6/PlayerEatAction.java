package cisc181.lab_6;

public class PlayerEatAction implements Action<FoodFight> {
    private FoodFight game;
    private int row;
    private int col;
    private Player player;

    public PlayerEatAction(FoodFight game,int row,int col,Player player){
        this.game=game;
        this.row=row;
        this.col=col;
        this.player=player;
    }

    @Override
    public boolean isValid(FoodFight game) {
        if(game.getBoard().getPiece(row,col).getSymbol()=='F'){
            return true;
        }
        else if(game.getBoard().getPiece(row,col).getSymbol()=='S'){
            return true;
        }
        else if(game.getBoard().getPiece(row,col).getSymbol()!='E'){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public void update(FoodFight game) {
        if(game.getBoard().getPiece(row,col).getSymbol()=='F'){
            Food food=(Food) game.getBoard().getPiece(row,col);
            player.eatFood(food);
        }
        else if(game.getBoard().getPiece(row,col).getSymbol()=='S'){
            SuperFood food=(SuperFood) game.getBoard().getPiece(row,col);
            player.eatSuper(food);
        }
        else if(game.getBoard().getPiece(row,col).getSymbol()!='E'){
            Player other=(Player) game.getBoard().getPiece(row,col);
            player.rob(other);
        }
        else{
        }
    }
}
