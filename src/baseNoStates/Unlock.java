package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Unlock extends Status {
  // Logger for logging messages related to the 'Unlock' class.

  private static final Logger logger = LoggerFactory.getLogger(Unlock.class);

  /**
   * Constructor for initializing an instance of 'Unlock'.
   * Takes a 'Door' object as a parameter and sets the initial state to 'UNLOCKED'.
   */
  public Unlock(Door door) {
    super(door);
    name = States.UNLOCKED;
  }


  /**Method for transitioning to the 'Locked' state.
   * This allows calling the method directly on an instance with '.locked()'
   * and sets the state to 'Locked'.
   */
  public void locked() {
    this.door.setState(new Locked(this.door));
  }
  /**Method for attempting to unlock the door.
   * Logs a message indicating that the door cannot be unlocked because it's already unlocked or open.
   */
  public void unlock() {
    logger.info("Can't unlock the door "
        + door.getId() + " because it's already unlocked or it's open");
  }

}
