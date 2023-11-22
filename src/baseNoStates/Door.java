package baseNoStates;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Represents a door in the system.
 */
public class Door {
  private static final Logger logger = LoggerFactory.getLogger(Door.class);
  private final String id;
  private Status state;
  private Space from;
  private Space to;
  private boolean closed;

  /**
   * Sets the state of the door.
   */
  public void setState(Status state) {
    this.state = state;
  }

  /**
   * Gets the 'from' Space of the door.
   */
  public Area getFrom() {
    return from;
  }

  /**
   * Gets the 'to' Space of the door.
   */
  public Area getTo() {return to;}




  /**
   * Initializes the Door with a unique identifier, a 'from' Space, and a 'to' Space.
   */
  public Door(String id, Space from, Space to) {
    state = new Locked(this);
    this.id = id;
    closed = true;
    this.from = from;
    this.to = to;
    this.to.addDoorGivingAccess(this);

  }

  /**
   * Processes a request to perform an action on the door.
   */
  public void processRequest(RequestReader request) {

    if (request.isAuthorized()) {
      String action = request.getAction();
      doAction(action);
    } else {
      logger.warn("not authorized");
    }
    request.setDoorStateName(getStateName());
  }

  private void doAction(String action) {
    switch (action) {
      case Actions.OPEN:
        if (closed && state.getName() == "unlocked") {
          closed = false;
        } else {
          logger.info("Can't open door " + id + " because it's already open");
        }
        break;
      case Actions.CLOSE:
        if (closed) {
          logger.info("Can't close door " + id + " because it's already closed");
        } else {
          closed = true;
        }
        break;
      case Actions.LOCK:
        if (!closed) {
          logger.info("Can't lock the door " + id + " because it's already open");
          break;
        } else {
          state.locked();
          break;
        }
        // fall through
      case Actions.UNLOCK:
        state.unlock();
        break;
      // fall through
      case Actions.UNLOCK_SHORTLY:
        // TODO
        logger.info("Action " + action + " not implemented yet");
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }

  /**
   * Checks if the door is closed.
   */
  public boolean isClosed() {
    return closed;
  }

  /**
   * Gets the unique identifier of the door.
   */
  public String getId() {
    return id;
  }

  /**
   * Gets the name of the current state of the door.
   */
  public String getStateName() {
    return state.getName();
  }

  @Override
  public String toString() {
    return "Door{"
        + ", id='" + id + '\''
        + ", closed=" + closed
        + ", state=" + getStateName()
        + "}";
  }

  public JSONObject toJson() {
    JSONObject json = new JSONObject();
    json.put("id", id);
    json.put("state", getStateName());
    json.put("closed", closed);
    return json;
  }


}
