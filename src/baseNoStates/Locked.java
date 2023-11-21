package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Locked extends Status {
  private static final Logger logger = LoggerFactory.getLogger(Locked.class);

  //Inicialitzem Locked, amb ajuda del costructor.
  public Locked(Door door) {
    super(door);
    name = States.LOCKED;
  }


  public void locked() {
    logger.warn("Can't lock the door " + this.door.getId() + " because it's already locked");
  }

  //
  public void unlock() {
    this.door.setState(new Unlock(this.door));
  }

}
