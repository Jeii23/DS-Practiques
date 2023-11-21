package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Unlock extends Status {
  private static final Logger logger = LoggerFactory.getLogger(Unlock.class);

  //Inicialitzem Unlock
  public Unlock(Door door) {
    super(door);
    name = States.UNLOCKED;
  }


  //Aquesta funció ens permet cridar-la directament a una altra funció fent .locked
  // i guarda l'estat que li passem.
  public void locked() {
    this.door.setState(new Locked(this.door));
  }

  public void unlock() {
    logger.info("Can't unlock the door "
        + door.getId() + " because it's already unlocked or it's open");
  }

}
