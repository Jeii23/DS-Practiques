package baseNoStates;

import java.util.logging.Logger;

public class Locked extends Status {
  Logger logger;

  //Inicialitzem Locked, amb ajuda del costructor.
  public Locked(Door door) {
    super(door);
    name = States.LOCKED;
  }


  public void locked() {
    logger.warning("Can't lock the door " + this.door.getId() + " because it's already locked");
  }

  //
  public void unlock() {
    this.door.setState(new Unlock(this.door));
  }

}
