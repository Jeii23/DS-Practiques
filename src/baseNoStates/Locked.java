package baseNoStates;

public class Locked extends Status{

  public Locked(Door door) {
    super(door);
    name = States.LOCKED;
  }


  public void locked(){
    System.out.println("Can't lock the door " + this.door.getId() + " because it's already locked");
  }
  public void unlock(){
    this.door.setState(new Unlock(this.door));
  }

}
