package cisc181.lab_6;

public class Player extends GamePiece {
    private int score;
    private boolean Super;
    private int superAging;
    public Player(char player,int score){
        super(player);
        this.score=score;
        Super=false;
        superAging=-1;
    }

    public int getScore() {
        return score;
    }

    public boolean isSuper() {
        return Super;
    }

    public void eatFood(Food food){
        score+=food.getFoodScore();
        System.out.println("Player "+Character.toString(getSymbol())+" eats a food and get "+food.getFoodScore()+" points.");
    }
    public void eatSuper(SuperFood food){
        Super=true;
        superAging=food.getAging();
        System.out.println("Player "+Character.toString(getSymbol())+" eats a superfood and get "+food.getAging()+" rounds of superpower.");
    }
    public void Aging(){
        if(superAging>0){
            superAging-=1;
            System.out.println("Player "+Character.toString(getSymbol())+" has "+superAging+" rounds of superpower left.");
        }
        else if(superAging==0){
            Super=false;
            System.out.println("Player "+Character.toString(getSymbol())+" loses superpower from now on.");
        }
        else{
            System.out.println("Player "+Character.toString(getSymbol())+" has no superpower");
        }
    }
    public void rob(Player o){
        if(Super) {
            int rob = o.getScore() / 2;
            score += rob;
            o.score -= rob;
            System.out.println("Player " + Character.toString(getSymbol()) + " rob " + Character.toString(o.getSymbol()) + " and got " +
                    +rob + " points.");
        }
        else{
            System.out.println("No super power, cannot rob.");
        }
    }


}
