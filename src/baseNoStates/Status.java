package baseNoStates;

public abstract class Status {
  protected Door door;
  protected String name;


  // Initialize Status
  public Status(Door door) {
    this.door = door;
  }

  // Get the name of the status
  public String getName() {
    return name;
  }

  // Abstract methods to be implemented by subclasses
  public abstract void locked();

  public abstract void unlock();


}
