package cisc181.lab_6;
import java.util.*;
public class Playgame {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.print("Input the symbol for first player: ");
        char player1=scan.next().toUpperCase().charAt(0);
        if(player1=='E'||player1=='F'||player1=='S'){
            System.out.print("The Symbol is not Valid. Input a new symbol for the first player: ");
            player1=scan.next().toUpperCase().charAt(0);
        }
        System.out.println("The first player is "+Character.toString(player1));
        System.out.print("Input the symbol for second player: ");
        char player2=scan.next().toUpperCase().charAt(0);
        if(player1=='E'||player1=='F'||player1=='S'){
            System.out.print("The Symbol is not Valid. Input a new symbol for the second player: ");
            player1=scan.next().toUpperCase().charAt(0);
        }
        else if(player1==player2){
            System.out.print("The Symbol cannot be same. Input the symbol for second player: ");
            player2=scan.next().charAt(0);
        }
        System.out.println("The second player is "+Character.toString(player2));
        Player A=new Player(player1,0);
        Player B=new Player(player2,0);
        char move;
        PlayerMoveAction action;
        System.out.print("input the row your want (at least 2):");
        int row=scan.nextInt();
        System.out.print("input the col your want (at least 2):");
        int col=scan.nextInt();
        System.out.print("input the score/food your want (at least 1):");
        int score=scan.nextInt();
        System.out.print("input the aging your want for the superfood (at least 1):");
        int aging=scan.nextInt();
        FoodFight game=new FoodFight(A,B,row,col,score,aging);
        System.out.println(game);
        while(!game.isEnd()){
            System.out.println("It is turn for "+game.getTurnPlayer());
            if(game.getTurnPlayer().isSuper()){
                //System.out.println("Player "+game.getTurnPlayer()+" has superpower.");
                game.getTurnPlayer().Aging();
            }
            System.out.print("Please input w, a, s or d to move: ");
            move=scan.next().charAt(0);
            action=new PlayerMoveAction(game.getTurnPlayer(),move);
            if(action.isValid(game)){
                action.update(game);
                System.out.println(game);
            }
            else{
                System.out.println("move not valid, please reinput.");
            }
            System.out.println(game.getTurnPlayer()+" : "+game.getTurnPlayer().getScore());
            System.out.println(game.getNotPlayer()+" : "+game.getNotPlayer().getScore());
        }
        System.out.println(game.Winner());
    }
}
