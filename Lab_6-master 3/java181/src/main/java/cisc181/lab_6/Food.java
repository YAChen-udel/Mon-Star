package cisc181.lab_6;

public class Food extends GamePiece {
    private int FoodScore;
    static final char FOOD = 'F';
    public Food(char symbol,int FoodScore){
        super(symbol);
        this.FoodScore=FoodScore;
    }

    public int getFoodScore() {
        return FoodScore;
    }
}
