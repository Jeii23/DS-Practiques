package baseNoStates;

public class Unlock extends Status{
  private String name;

  public Unlock(Door door) {
    super(door);
    name = "unlocked";
  }
  public String getName(){return name;}


  public void locked() {
    this.door.setState(new Locked(this.door));
  }
  public void unlock() {
    System.out.println("Can't unlock the door " + door.getId() + " because it's already unlocked or it's open");
  }

}
