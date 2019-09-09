package cisc181.lab_6;

import org.junit.Test;
import static org.junit.Assert.*;


public class TrainTest {

    @Test
    public void test_Train() {

        System.out.println("Testing Train");

        Train cargoTrain = new Train();

        cargoTrain.attachAtFront("coal");
       assertEquals(cargoTrain.getHeadCargo().equals("coal"),true);

        cargoTrain.attachAtFront("bananas");
        assertEquals(cargoTrain.getHeadCargo().equals("bananas"),true);

        cargoTrain.attachAtEnd("lumber");
        cargoTrain.attachAtEnd("apples");


        assertEquals(cargoTrain.removeFromFront().equals("bananas"),true);
        assertEquals(cargoTrain.removeFromFront().equals("coal"),true);

        // add more TrainCars to your Train and  add Test cases to remove them
        cargoTrain.attachAtFront("people");
        assertEquals(cargoTrain.getHeadCargo().equals("people"),true);
        cargoTrain.attachAtFront("pigs");
        assertEquals(cargoTrain.getHeadCargo().equals("pigs"),true);
        assertEquals(cargoTrain.removeFromEnd().equals("apples"),true);
        assertEquals(cargoTrain.removeFromEnd().equals("lumber"),true);
        assertEquals(cargoTrain.removeFromFront().equals("pigs"),true);
        assertEquals(cargoTrain.removeFromFront().equals("people"),true);
        assertEquals(cargoTrain.removeFromEnd()==null,true);
        cargoTrain.attachAtEnd("air");
        assertEquals(cargoTrain.getHeadCargo().equals("air"),true);

    }

}