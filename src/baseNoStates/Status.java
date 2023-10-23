package baseNoStates;

public abstract class Status {
 protected Door door;
 protected String name;

  public Status(Door door) {
    this.door =door;
  }
  public  String getName(){return name;}
  public abstract void locked();
  public abstract void unlock();


}
