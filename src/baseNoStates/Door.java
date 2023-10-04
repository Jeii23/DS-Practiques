package baseNoStates;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;


public class Door {
  private final String id;
  private Status state;
  private Locked lock;
  private boolean closed; // physically
  public Door(String id) {
   state = new Locked(id);
    this.id = id;
    closed = true;

  }
//new doorstate(this)
  // new locked(this)
  public void processRequest(RequestReader request) {
    // it is the Door that process the request because the door has and knows
    // its state, and if closed or open
    if (request.isAuthorized()) {
      String action = request.getAction();
      doAction(action);
    } else {
      System.out.println("not authorized");
    }
    request.setDoorStateName(getStateName());
  }

  private void doAction(String action) {
    switch (action) {
      case Actions.OPEN:
        if (closed && !state.isLocked()) {
          closed = false;
        } else {
          System.out.println("Can't open door " + id + " because it's already open");
        }
        break;
      case Actions.CLOSE:
        if (closed) {
          System.out.println("Can't close door " + id + " because it's already closed");
        } else {
          closed = true;
        }
        break;
      case Actions.LOCK:
        // TODO
        if (state.isLocked() || !closed ) {
          System.out.println("Can't lock the door " + id + " because it's already locked or it's open");
        } else {


        }
        break;
        // fall through
      case Actions.UNLOCK:
        // TODO
        if (!state.isLocked() || !closed ) {
          System.out.println("Can't unlock the door " + id + " because it's already unlocked or it's open");
        } else {
          lock.setLocked(false);
        }
        break;
        // fall through
      case Actions.UNLOCK_SHORTLY:
        // TODO
        System.out.println("Action " + action + " not implemented yet");
        break;
      default:
        assert false : "Unknown action " + action;
        System.exit(-1);
    }
  }

  public boolean isClosed() {
    return closed;
  }

  public String getId() {
    return id;
  }

  public String getStateName() {
    if (!state.isLocked())
      return "unlocked";
    else
      return "locked";
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
