package baseNoStates;

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
