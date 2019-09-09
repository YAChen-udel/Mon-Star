package cisc181.lab_6;

public class PlayerMoveAction implements Action<FoodFight> {
    private char move;
    private Player player;
    public PlayerMoveAction(Player player,char move){
        this.player=player;
        this.move=Character.toLowerCase(move);
    }
    @Override
    public boolean isValid(FoodFight game) {
        int i=game.getLoc(player)[0];
        int j=game.getLoc(player)[1];
        if(game.getTurnPlayer()==player){
            if(move=='w'){
                return game.getBoard().isInBounds(i-1,j);
            }
            else if(move=='a'){
                return game.getBoard().isInBounds(i,j-1);
            }
            else if(move=='s'){
                return game.getBoard().isInBounds(i+1,j);
            }
            else if(move=='d'){
                return game.getBoard().isInBounds(i,j+1);
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }

    }

    @Override
    public void update(FoodFight game) {
        int i=game.getLoc(player)[0];
        int j=game.getLoc(player)[1];
        boolean canmove;
        PlayerEatAction action;
        game.setPiece(i,j,new GamePiece(GamePiece.EMPTY));
        if(move=='w'){
            action=new PlayerEatAction(game,i-1,j,player);
            canmove=action.isValid(game);
            if(canmove){
                action.update(game);
                game.setPiece(i-1,j,player);

            }
            else{
                game.setPiece(i,j,player);
            }
            game.changeTurn();
        }
        else if(move=='a'){
            action=new PlayerEatAction(game,i,j-1,player);
            canmove=action.isValid(game);
            if(canmove){
                action.update(game);
                game.setPiece(i,j-1,player);
            }
            else{
                game.setPiece(i,j,player);
            }
            game.changeTurn();
        }
        else if(move=='s'){
            action=new PlayerEatAction(game,i+1,j,player);
            canmove=action.isValid(game);
            if(canmove){
                action.update(game);
                game.setPiece(i+1,j,player);
            }
            else{
                game.setPiece(i,j,player);
            }
            game.changeTurn();
        }
        else if(move=='d'){
            action=new PlayerEatAction(game,i,j+1,player);
            canmove=action.isValid(game);
            if(canmove){
                action.update(game);
                game.setPiece(i,j+1,player);
            }
            else{
                game.setPiece(i,j,player);
            }
            game.changeTurn();
        }
        else{
            game.setPiece(i,j,player);
        }
    }
    /*public boolean eat(FoodFight game,int row,int col){
        if(game.getBoard().getPiece(row,col).getSymbol()=='F'){
            Food food=(Food) game.getBoard().getPiece(row,col);
            player.eatFood(food);;
            return true;
        }
        else if(game.getBoard().getPiece(row,col).getSymbol()=='S'){
            SuperFood food=(SuperFood) game.getBoard().getPiece(row,col);
            player.eatSuper(food);
            return true;
        }
        else if(game.getBoard().getPiece(row,col).getSymbol()!='E'){
            Player other=(Player) game.getBoard().getPiece(row,col);
            player.rob(other);
            return false;
        }
        else{
            return true;
        }
    }*/
    @Override
    public String toString() {
        return "Move Player "+Character.toString(player.getSymbol())+" to "+move+".";
    }
}
