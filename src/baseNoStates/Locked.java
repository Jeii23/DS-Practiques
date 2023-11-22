package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the locked state of a door. Extends the Status class.
 */
public class Locked extends Status {

  // Logger for logging messages.
  private static final Logger logger = LoggerFactory.getLogger(Locked.class);

  /**
   * Initializes the Locked state for a door using the constructor of the base class.
   */  public Locked(Door door) {
    super(door);
    name = States.LOCKED;
  }

  /**
   * Method called when an attempt is made to lock the door that is already locked.
   * Logs a warning message.
   */
  public void locked() {
    logger.warn("Can't lock the door " + this.door.getId() + " because it's already locked");
  }

  /**
   * Transition to the Unlock state when unlocking the door.
   */
  public void unlock() {
    this.door.setState(new Unlock(this.door));
  }

}
