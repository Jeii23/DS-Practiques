package baseNoStates;

public abstract class Status {
 protected Door door;
  public Status(Door door) {
    this.door =door;
  }

  public void locked() {}
  public void unlock() {

  }


}
