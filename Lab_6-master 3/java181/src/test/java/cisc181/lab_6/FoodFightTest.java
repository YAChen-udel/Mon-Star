package cisc181.lab_6;

import org.junit.Test;

import static org.junit.Assert.*;

public class FoodFightTest {
    @Test
    public void test_setup(){
        System.out.println("Testing setup");
        Player A=new Player('A',0);
        Player B=new Player('B',0);
        FoodFight game=new FoodFight(A,B,2,2,1,3);
        System.out.println(game);
        /*PlayerMoveAction action1=new PlayerMoveAction(A,'s');
        PlayerMoveAction action2=new PlayerMoveAction(A,'d');
        PlayerMoveAction action3=new PlayerMoveAction(A,'a');
        PlayerMoveAction action4=new PlayerMoveAction(A,'w');
        assertTrue(action1.isValid(game));
        assertTrue(action2.isValid(game));
        assertFalse(action3.isValid(game));
        assertFalse(action4.isValid(game));
        action1.update(game);
        System.out.println(game);
        System.out.println(A.getScore());
        assertFalse(action2.isValid(game));
        System.out.println(game.Winner());
        PlayerMoveAction action5=new PlayerMoveAction(B,'w');
        PlayerMoveAction action6=new PlayerMoveAction(B,'a');
        PlayerMoveAction action7=new PlayerMoveAction(B,'s');
        PlayerMoveAction action8=new PlayerMoveAction(B,'d');
        action5.update(game);
        System.out.println(game);
        System.out.println(A.getScore()+" "+B.getScore());
        action1.update(game);
        System.out.println(game);
        System.out.println(A.getScore()+" "+B.getScore());
        action5.update(game);
        System.out.println(game);
        System.out.println(A.getScore()+" "+B.getScore());
        action2.update(game);
        System.out.println(game);
        System.out.println(A.getScore()+" "+B.getScore());
        action6.update(game);
        System.out.println(game);
        System.out.println(A.getScore()+" "+B.getScore());
        action4.update(game);
        System.out.println(game);
        System.out.println(A.getScore()+" "+B.getScore());
        System.out.println(game.Winner());*/



    }
}