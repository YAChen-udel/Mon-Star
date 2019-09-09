package cisc181.lab_6;

public class Train {
    private TrainCar head;
    /*
    onstructor don't accept any parameters and sets head to null
     */
    public Train(){
        head=null;
    }
    /*
    return the first traincar's cargo
     */
    public String getHeadCargo(){
        return head.getCargo();
    }
    /*
    accepts a String representing the cargo that the  new TrainCar will carry and attaches a new
    TrainCar to the front of the Train and set this new TrainCar as the head.
     */
    public void attachAtFront(String cargo){
        TrainCar tmp=new TrainCar(cargo,head);
        head=tmp;
    }
    /*
    removes the first TrainCar from the train and returns the cargo that it held
     */
    public String removeFromFront(){
        String cargo=null;
        if(head!=null) {
            TrainCar tmp = head.getNext();
            cargo= head.getCargo();
            head = tmp;
        }
        return cargo;
    }
    /*
    accepts a String representing the cargo that the new TrainCar will carry and
    attaches a new TrainCar to the end of the Train
     */
    public void attachAtEnd(String cargo){
        TrainCar tmp=new TrainCar(cargo,null);
        if(head!=null) {
            TrainCar current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(tmp);
        }
        else{
            head=tmp;
        }
    }
    /*
    removes the last TrainCar from the train and returns the cargo that it held
     */
    public String removeFromEnd(){
        String cargo=null;
        TrainCar current=head;
        if(head!=null) {
            while(current.getNext().getNext()!=null){
                current=current.getNext();
            }
            cargo=current.getNext().getCargo();
            current.setNext(null);
        }
        return cargo;
    }

}
