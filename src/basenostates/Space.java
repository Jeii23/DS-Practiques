package basenostates;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Represents a space within the system, extending the concept of an area.
 */
public class Space extends Area {

  // List of doors that provide access to this space.
  private ArrayList<Door> doorsGivingAccess;

  /**
   * Initializes a space with the specified ID.
   */
  public Space(String id) {
    super(id);
    doorsGivingAccess = new ArrayList<Door>();

  }
  public JSONObject toJson(int depth) { // depth not used here
    JSONObject json = new JSONObject();
    json.put("class", "space");
    json.put("id", id);
    JSONArray jsonDoors = new JSONArray();
    for (Door d : doorsGivingAccess) {
      jsonDoors.put(d.toJson());
    }
    json.put("access_doors", jsonDoors);
    return json;
  }
  /**
   * Returns the list of doors that provide access to this space.
   */
  public ArrayList<Door> getDoorsGivingAccess() {
    return doorsGivingAccess;
  }

  /**
   * Adds a door to the list of doors that provide access to this space.
   */
  public void addDoorGivingAccess(Door door) {
    doorsGivingAccess.add(door);
  }

  /**
   * Accepts a visitor for visiting this space.
   */
  @Override
  public void acceptVisitor(Visitor v) {
    v.visitSpace(this);
  }
}
