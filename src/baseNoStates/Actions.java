package baseNoStates;

import java.util.logging.Logger;

public final class Actions {
  private static final Logger LOGGER = Logger.getLogger(Actions.class.getName());

  // Possible actions in reader and area requests
  public static final String LOCK = "lock";
  public static final String UNLOCK = "unlock";
  public static final String UNLOCK_SHORTLY = "unlock_shortly";
  LOGGER.info("Possible actions in reader and area requests: LOCK, UNLOCK, UNLOCK_SHORTLY");

  // Possible actions in door requests
  public static final String OPEN = "open";
  public static final String CLOSE = "close";
  LOGGER.info("Possible actions in door requests: OPEN, CLOSE");
}
