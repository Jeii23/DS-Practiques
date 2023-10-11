package baseNoStates;

public class Locked extends Status{

  private String name;
  public Locked(Door door) {
    super(door);
    name = "locked";
  }

  public void locked(){}
  public void unlock(){
    this.door.setState(new Unlock(this.door));
  }

}
