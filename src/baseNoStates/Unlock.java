package baseNoStates;

public class Unlock extends Status{
  private String name;

  public Unlock(Door door) {
    super(door);
    name = "unlocked";
  }

  public void locked(Door door) {
    door.setState(new Locked(door));
  }
  public void unlock() {}

}
