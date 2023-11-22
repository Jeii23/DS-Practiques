package baseNoStates;

public class UnlockShortly extends Status {
  /**Constructor for initializing an instance of 'UnlockShortly'.
   * Takes a 'Door' object as a parameter and calls the constructor of the superclass 'Status'.
   */

  public UnlockShortly(Door door) {
    super(door);
  }


  @Override
  public void locked() {

  }

  @Override
  public void unlock() {

  }
}
