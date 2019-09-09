package cisc181.lab_6;

public class SuperFood extends GamePiece {
    private int Aging;
    static final char SUPER = 'S';
    public SuperFood(char symbol,int Aging){
        super(symbol);
        this.Aging=Aging;
    }

    public int getAging() {
        return Aging;
    }
}
