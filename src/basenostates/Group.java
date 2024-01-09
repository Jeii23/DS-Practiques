package basenostates;

import java.util.ArrayList;

/**
 * Represents a group of users with specific access privileges and schedules.
 */
public class Group {
  // List of areas accessible by the group.
  private ArrayList<Area> areasAccess;

  // Name of the group.
  private String name;

  // List of actions the group can perform.
  private ArrayList<String> actions;

  // Schedule specifying the group's access time.
  private Schedule schedule;


  /**
   * Constructor that initializes the group with access areas, a name, actions, and a schedule.
   */
  public Group(ArrayList<Area> areasAccess,
               String name, ArrayList<String> actions, Schedule schedule) {
    this.areasAccess = areasAccess;
    this.name = name;
    this.actions = actions;
    this.schedule = schedule;
  }

  /**
   * Gets the schedule of the group.
   */
  public Schedule getSchedule() {
    return schedule;
  }

  /**
   * Checks if the group can access a specific space by iterating through its areasAccess.
   * If the space is found, returns true. If the space is not directly found,
   * checks if it's inside a partition, converting areas in the array to partitions,
   * and searches within that partition.
   */
  public boolean canAccess(Area space) {
    GetDoorsGivingAccessVisitor visitor = new GetDoorsGivingAccessVisitor();
    space.acceptVisitor(visitor);
    for (Area access : areasAccess) {
      for (Area a : visitor.getArea(access)) {
        if (a.equals(space)) {
          return true;
        }
      }
    }
    return false;
  }


  /**
   * Checks if the group can perform a specific action by iterating through the actions array.
   * If the action is found, returns true. Otherwise, returns false.
   */
  public boolean canDoAction(String action) {
    for (String actions : actions) {
      if (actions.equals(action)) {
        return true;
      }
    }
    return false;
  }



}
