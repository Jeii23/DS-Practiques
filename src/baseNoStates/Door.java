package baseNoStates;


import baseNoStates.requests.RequestReader;
import org.json.JSONObject;

import java.time.LocalDateTime;


public class Door implements Building {
  private final String id;
  private Status state;


  private RequestReader request;
  private User user;

  public void setState(Status state) {
    this.state = state;
  }

  private boolean closed; // physically
  public Door(String id) {
   state = new Locked(this);
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
        if (closed && state.getName()=="unlocked") {
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
        if (!closed) {
          System.out.println("Can't lock the door " + id + " because it's already open");
          break;
        }
        else {
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

        LocalDateTime time = LocalDateTime.now();
        request= new RequestReader(user.getCredential(), Actions.UNLOCK_SHORTLY,time,getId());

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
