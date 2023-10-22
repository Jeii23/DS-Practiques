package baseNoStates;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;

import java.util.ArrayList;

public class Space extends Area{
  private ArrayList<Door> doorsGivingAccess;
  public Space(String id) {
    super(id);
    doorsGivingAccess = new ArrayList<Door>();

  }

  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    return doorsGivingAccess;
  }

  public void addDoorGivingAccess(Door door) {
    doorsGivingAccess.add(door);
  }
  public  Area findAreaById(String id) {
    if (this.id.equals(id)) {
      return this;
    }
    System.out.println("Area with id " + id + " not found");
    return null; // otherwise we get a Java error
  }
}
