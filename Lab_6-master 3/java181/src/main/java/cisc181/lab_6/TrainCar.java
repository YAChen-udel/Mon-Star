package cisc181.lab_6;

public class TrainCar {
    private String cargo;
    private TrainCar next;
    public TrainCar(String cargo,TrainCar next){
        this.cargo=cargo;
        this.next=next;
    }
    /*
    getter for the cargo
     */
    public String getCargo() {
        return cargo;
    }
    /*
    getter for next
     */
    public TrainCar getNext() {
        return next;
    }
    /*
    setter for cargo
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    /*
    setter for next
     */
    public void setNext(TrainCar next) {
        this.next = next;
    }
    /*
    Override toString method
     */
    @Override
    public String toString() {
        return cargo;
    }
}
